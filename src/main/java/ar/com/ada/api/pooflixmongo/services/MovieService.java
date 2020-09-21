package ar.com.ada.api.pooflixmongo.services;


import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.pooflixmongo.entities.Movie;
import ar.com.ada.api.pooflixmongo.repos.MovieRepo;

@Service
public class MovieService {
    @Autowired
    MovieRepo mR;

    public Optional<Movie> movieExistsById(ObjectId _id) {
        return Optional.of(mR.findBy_id(_id));
    }

    public Optional<Movie> createMovie(String title, String releaseDate, boolean awardWinner, List<String> genres, String directress, List<String> actresses) {
        Optional<Movie> movieOp; // = mR.findMovieByTitle(title);
        title = title + "(" + Thread.currentThread().getName() + ")";
        movieOp = Optional.of(mR.save(new Movie(title, releaseDate, awardWinner, genres, directress, actresses)));
        return movieOp;
        /*return movieOp.isEmpty() ? Optional.of(mR.save(new Movie(title, releaseDate, awardWinner, genres, directress, actresses)))
                : movieOp;*/
    }

    public Optional<Movie> getMovieById(ObjectId _id) {
        Optional<Movie> movieOp = movieExistsById(_id);
        return movieOp.isPresent() ? movieOp : Optional.empty();
    }

    public Optional<Movie> getMovieByTitle (String title) {
        Optional<Movie> movieOp = mR.findMovieByTitle(title);
        return movieOp.isPresent() ? movieOp : Optional.empty();
    }    
}
