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

import ar.com.ada.api.pooflixmongo.entities.Directress;
import ar.com.ada.api.pooflixmongo.models.requests.DirectressCreationRequest;
import ar.com.ada.api.pooflixmongo.models.responses.DirectressResponse;
import ar.com.ada.api.pooflixmongo.models.responses.GenericResponse;
import ar.com.ada.api.pooflixmongo.services.DirectressService;

@RestController
public class DirectressController {
    /**
     * GET api/Directress/{byName}: obtener data de la actriz by name sin movies 
     * GET api/Directress/{byName}/movies: obtener lista de movies de una actriz 
     * por nombre sin data ActreesMovieListResponse 
     * GET api/Directress/{byName}/movies/{genreId}: obtener lista de movies de 
     * una actriz de un género por su id DirectressMovieByGenreListResponse 
     * PUT api/Directress/{byId}: actualizar data de la actriz updateDirectressRequest 
     * updateDirectressResponse
     */

    @Autowired
    DirectressService dS;

    @PostMapping("/api/directresses")
    public ResponseEntity<GenericResponse> createDirectress(@RequestBody DirectressCreationRequest aCR) {
        Optional<Directress> directressCreated = dS.createDirectress(aCR.name, aCR.birthDate, aCR.nationality);
        return directressCreated.isPresent()
                ? ResponseEntity.ok(new GenericResponse(directressCreated.get().get_id(), "SUCCESS", true))
                : ResponseEntity.badRequest().build();
    }

    @GetMapping("/api/directresses/{id}")
    public ResponseEntity<DirectressResponse> getDirectressById(@PathVariable ObjectId id) {
        Optional<Directress> directressOp = dS.getDirectressById(id);
        return directressOp.isPresent() ? ResponseEntity.ok(new DirectressResponse(directressOp.get().getName(),
                directressOp.get().getBirthDate(), directressOp.get().getNationality()))
                : ResponseEntity.badRequest().build();
    }

    @GetMapping("/api/directresses/{fullName}")
    public ResponseEntity<DirectressResponse> getDirectressByName(@PathVariable String fullName) {
        Optional<Directress> directressOp = dS.getDirectressByName(fullName);
        return directressOp.isPresent() ? ResponseEntity.ok(new DirectressResponse(directressOp.get().getName(),
                directressOp.get().getBirthDate(), directressOp.get().getNationality()))
                : ResponseEntity.badRequest().build();
    }
}
