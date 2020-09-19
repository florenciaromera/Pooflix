package ar.com.ada.api.pooflixmongo.services;

import java.util.*;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.pooflixmongo.entities.Directress;
import ar.com.ada.api.pooflixmongo.repos.DirectressRepo;

@Service
public class DirectressService {
    @Autowired
    DirectressRepo dR;

    public Optional<Directress> directressExistsById(ObjectId _id) {
        return Optional.of(dR.findBy_id(_id));
    }

    public Optional<Directress> createDirectress(String name, Date birthDate, String nationality) {
        Optional<Directress> directressOp = dR.findDirectressByName(name);
        return !directressOp.isPresent() ? Optional.of(dR.save(new Directress(name, birthDate, nationality)))
                : directressOp;
    }

    public Optional<Directress> createDirectress(String name) {
        Optional<Directress> directressOp = dR.findDirectressByName(name);
        return !directressOp.isPresent() ? Optional.of(dR.save(new Directress(name)))
                : directressOp;
    }

    public Optional<Directress> getDirectressById(ObjectId id) {
        Optional<Directress> directressOp = directressExistsById(id);
        return directressOp.isPresent() ? directressOp : Optional.empty();
    }

    public Optional<Directress> getDirectressByName(String fullName) {
        Optional<Directress> directressOp = dR.findDirectressByName(fullName);
        return directressOp.isPresent() ? directressOp : Optional.empty();
    }   
    
    public synchronized void addOrEditDirectressFromListener(ObjectId _id, String name){
        Optional<Directress> directressOp = createDirectress(name);
        Directress d = directressOp.get();
        List<ObjectId> moviesList = d.getMovies();
        if(!moviesList.contains(_id)){
            moviesList.add(_id);
            d.setMovies(moviesList);
            dR.save(d);
        }
    }
}
