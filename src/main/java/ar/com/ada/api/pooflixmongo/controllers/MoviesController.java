package ar.com.ada.api.pooflixmongo.controllers;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.pooflixmongo.entities.Movie;
import ar.com.ada.api.pooflixmongo.models.requests.MovieCreationRequest;
import ar.com.ada.api.pooflixmongo.models.requests.MovieCreationRequestList;
import ar.com.ada.api.pooflixmongo.models.responses.CreateMoviesResponse;
import ar.com.ada.api.pooflixmongo.models.responses.GenericResponse;
import ar.com.ada.api.pooflixmongo.models.responses.MovieResponse;
import ar.com.ada.api.pooflixmongo.services.MovieService;

@RestController
public class MoviesController {

    @Autowired
    MovieService movieService;

    @PostMapping("/api/movies/batches")
    public ResponseEntity<CreateMoviesResponse> createMovies(@RequestBody MovieCreationRequestList mCR) {
        System.out.println(new Date().toString());
        for (MovieCreationRequest m : mCR.getM()) {
            movieService.createMovie(m.title, m.releaseDate, m.awardWinner, m.genre, m.director, m.actors);
        }
        return ResponseEntity.ok(new CreateMoviesResponse("SUCCESS!",true));
    }

    
    @PostMapping("/api/movies")
    public ResponseEntity<?> createMovie(@RequestBody MovieCreationRequestList mCR) {
        System.out.println(new Date().toString());
        for (MovieCreationRequest m : mCR.getM()) {
            movieService.createMovie(m.title, m.releaseDate, m.awardWinner, m.genre, m.director, m.actors);
        }
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/api/movies/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable ObjectId id) {
        Optional<Movie> movieOp = movieService.getMovieById(id);
        return movieOp.isPresent() ? ResponseEntity.ok(new MovieResponse(movieOp.get().getTitle(),
                movieOp.get().getReleaseDate(), movieOp.get().isAwardWinner())) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/api/movies/{title}")
    public ResponseEntity<MovieResponse> getMovieByTitle(@PathVariable String title) {
        Optional<Movie> movieOp = movieService.getMovieByTitle(title);
        return movieOp.isPresent() ? ResponseEntity.ok(new MovieResponse(movieOp.get().getTitle(),
                movieOp.get().getReleaseDate(), movieOp.get().isAwardWinner())) : ResponseEntity.badRequest().build();
    }
}
