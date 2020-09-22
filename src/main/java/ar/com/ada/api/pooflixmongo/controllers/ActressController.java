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

import ar.com.ada.api.pooflixmongo.entities.Actress;
import ar.com.ada.api.pooflixmongo.models.requests.ActressCreationRequest;
import ar.com.ada.api.pooflixmongo.models.responses.ActressMoviesListResponse;
import ar.com.ada.api.pooflixmongo.models.responses.ActressResponse;
import ar.com.ada.api.pooflixmongo.models.responses.GenericResponse;
import ar.com.ada.api.pooflixmongo.services.ActressService;

@RestController
public class ActressController {
    /**
     * GET api/actress/{byName}: obtener data de la actriz by name sin movies 
     * GET api/actress/{byName}/movies: obtener lista de movies de una actriz 
     * por nombre sin data ActreesMovieListResponse 
     * GET api/actress/{byName}/movies/{genreId}: obtener lista de movies de 
     * una actriz de un género por su id ActressMovieByGenreListResponse 
     * PUT api/actress/{byId}: actualizar data de la actriz updateActressRequest 
     * updateActressResponse
     */

    @Autowired
    ActressService actressService;

    @PostMapping("/api/actresses")
    public ResponseEntity<GenericResponse> createActress(@RequestBody ActressCreationRequest aCR) {
        Optional<Actress> actressCreated = actressService.createActress(aCR.name, aCR.birthDate, aCR.nationality);
        return actressCreated.isPresent()
                ? ResponseEntity.ok(new GenericResponse(actressCreated.get().get_id(), "SUCCESS", true))
                : ResponseEntity.badRequest().build();
    }

    @GetMapping("/api/actresses/{id}")
    public ResponseEntity<ActressResponse> getActressById(@PathVariable ObjectId id) {
        Optional<Actress> actressOp = actressService.getActressById(id);
        return actressOp.isPresent() ? ResponseEntity.ok(new ActressResponse(actressOp.get().getName(),
                actressOp.get().getBirthDate(), actressOp.get().getNationality()))
                : ResponseEntity.badRequest().build();
    }

    @GetMapping("/api/actresses/{fullName}/movies")
    public ResponseEntity<ActressMoviesListResponse> getActressMovieListByName(@PathVariable String fullName) {
        Optional<ActressMoviesListResponse> actressMLROp = actressService.getActressMovieListByName(fullName);
        return actressMLROp.isPresent() ? ResponseEntity.ok(actressMLROp.get()) : ResponseEntity.badRequest().build();
    }
}
