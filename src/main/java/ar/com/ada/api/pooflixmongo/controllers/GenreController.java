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

import ar.com.ada.api.pooflixmongo.entities.Genre;
import ar.com.ada.api.pooflixmongo.models.requests.GenreCreationRequest;
import ar.com.ada.api.pooflixmongo.models.responses.GenericResponse;
import ar.com.ada.api.pooflixmongo.models.responses.GenreResponse;
import ar.com.ada.api.pooflixmongo.services.GenreService;

@RestController
public class GenreController {
   
    @Autowired
    GenreService genreService;

    @PostMapping("/api/genre")
    public ResponseEntity<GenericResponse> createGenre(@RequestBody GenreCreationRequest gCR) {
        Optional<Genre> genreCreated = genreService.createGenre(gCR.name, gCR.description);
        return genreCreated.isPresent()
                ? ResponseEntity.ok(new GenericResponse(genreCreated.get().get_id(), "SUCCESS", true))
                : ResponseEntity.badRequest().build();
    }

    @GetMapping("/api/genre/{id}")
    public ResponseEntity<GenreResponse> getGenreById(@PathVariable ObjectId id) {
        Optional<Genre> genreOp = genreService.getGenreById(id);
        return genreOp.isPresent() ? ResponseEntity.ok(new GenreResponse(genreOp.get().getName(),
                genreOp.get().getDescription())) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/api/genre/{name}")
    public ResponseEntity<GenreResponse> getGenreByName(@PathVariable String name) {
        Optional<Genre> genreOp = genreService.getGenreByName(name);
        return genreOp.isPresent() ? ResponseEntity.ok(new GenreResponse(genreOp.get().getName(),
                genreOp.get().getDescription())) : ResponseEntity.badRequest().build();
    }
}
