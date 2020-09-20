package ar.com.ada.api.pooflixmongo.services;

import java.util.*;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.pooflixmongo.builders.ActressMoviesBuilder;
import ar.com.ada.api.pooflixmongo.entities.Actress;
import ar.com.ada.api.pooflixmongo.models.responses.ActressMoviesListResponse;
import ar.com.ada.api.pooflixmongo.repos.ActressRepo;

@Service
public class ActressService {
    @Autowired
    ActressRepo aR;

    @Autowired
    ActressMoviesBuilder actressMoviesBuilder;

    public Optional<Actress> actressExistsById(ObjectId _id) {
        return Optional.of(aR.findBy_id(_id));
    }

    public Optional<Actress> createActress(String name, Date birthDate, String nationality) {
        Optional<Actress> actressOp = aR.findActressByName(name);
        return !actressOp.isPresent() ? Optional.of(aR.save(new Actress(name, birthDate, nationality)))
                : actressOp;
    }

    public Optional<Actress> createActress(String name) {
        Optional<Actress> actressOp = aR.findActressByName(name);
        return !actressOp.isPresent() ? Optional.of(aR.save(new Actress(name)))
                : actressOp;
    }

    public Optional<Actress> getActressById(ObjectId id) {
        Optional<Actress> actressOp = actressExistsById(id);
        return actressOp.isPresent() ? actressOp : Optional.empty();
    }

    public Optional<Actress> getActressByName(String fullName) {
        Optional<Actress> actressOp = aR.findActressByName(fullName);
        return actressOp.isPresent() ? actressOp : Optional.empty();
    }

    public void addOrEditActressFromListener(ObjectId _id, List<String> names){
        List<Optional<Actress>> opList = new ArrayList<>();
        synchronized (this) {
            opList = names.stream().map(s -> createActress(s)).collect(Collectors.toList());
        }
        List<Actress> actressList = new ArrayList<>();
        for(Optional<Actress> opActress : opList){
            Actress a = opActress.get();
            List<ObjectId> objectId = a.getMovies();
            if(!objectId.contains(_id)){
                objectId.add(_id);
            }
            a.setMovies(objectId);
            actressList.add(a);    
        }
        aR.saveAll(actressList);
    }

	public Optional<ActressMoviesListResponse> getActressMovieListByName(String fullName) {
        Optional<Actress> a = getActressByName(fullName);
        return a.isPresent() ? Optional.of(actressMoviesBuilder.build(a.get())) : Optional.empty();
	}
}
