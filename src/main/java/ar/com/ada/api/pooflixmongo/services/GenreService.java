package ar.com.ada.api.pooflixmongo.services;

import java.util.*;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.pooflixmongo.entities.Genre;
import ar.com.ada.api.pooflixmongo.repos.GenreRepo;

@Service
public class GenreService {
    @Autowired
    GenreRepo gR;

    private Integer recurso = 0;

    public Optional<Genre> genreExistsById(ObjectId _id) {
        return Optional.of(gR.findBy_id(_id));
    }

    public Optional<Genre> createGenre(String name, String description) {
        Optional<Genre> genreOp = gR.findGenreByName(name);
        return !genreOp.isPresent() ? Optional.of(gR.save(new Genre(name, description))) : genreOp;
    }

    public Optional<Genre> createGenre(String name) {
        Optional<Genre> genreOp = gR.findGenreByName(name);
        return !genreOp.isPresent() ? Optional.of(gR.save(new Genre(name))) : genreOp;
    }

    public Optional<Genre> getGenreById(ObjectId id) {
        Optional<Genre> genreOp = genreExistsById(id);
        return genreOp.isPresent() ? genreOp : Optional.empty();
    }

    public Optional<Genre> getGenreByName(String fullName) {
        Optional<Genre> genreOp = gR.findGenreByName(fullName);
        return genreOp.isPresent() ? genreOp : Optional.empty();
    }

    public void addOrEditGenreFromListener(ObjectId _id, List<String> genres) {
        List<Optional<Genre>> opList = new ArrayList<>();
        synchronized (this.recurso) {
            opList = genres.stream().map(s -> createGenre(s)).collect(Collectors.toList());
        }
        List<Genre> genresList = new ArrayList<>();
        for (Optional<Genre> opGenre : opList) {
            Genre g = opGenre.get();
            List<ObjectId> objectId = g.getMovies();
            if (!objectId.contains(_id)) {
                objectId.add(_id);
            }
            g.setMovies(objectId);
            genresList.add(g);
        }
        gR.saveAll(genresList);
    }
}
