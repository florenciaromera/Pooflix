package ar.com.ada.api.pooflixmongo.builders;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ada.api.pooflixmongo.entities.Actress;
import ar.com.ada.api.pooflixmongo.entities.Movie;
import ar.com.ada.api.pooflixmongo.models.responses.ActressMoviesListResponse;
import ar.com.ada.api.pooflixmongo.services.MovieService;

@Component
public class ActressMoviesBuilder {
    @Autowired
    MovieService movieService;

    public ActressMoviesListResponse build(Actress actress) {
        List<Movie> movies = new ArrayList<>();
        for (ObjectId m : actress.getMovies()) {
            movies.add(movieService.getMovieById(m).get());
        }
        return new ActressMoviesListResponse(actress.getName(), movies);
    }
}
