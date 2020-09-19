package ar.com.ada.api.pooflixmongo.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.pooflixmongo.models.responses.EpisodeResponse;
import ar.com.ada.api.pooflixmongo.services.SeriesService;

@RestController
public class SeriesController {
    @Autowired
    SeriesService seriesService;

    @GetMapping("/api/series/{id}/episodes/{seasonNumber}-{episodeNumber}")
    public ResponseEntity<EpisodeResponse> getEpisode(@PathVariable ObjectId id, @PathVariable Integer seasonNumber, @PathVariable Integer episodeNumber){
        seriesService.getEpisode(id, seasonNumber, episodeNumber);
        return ResponseEntity.ok(new EpisodeResponse());
    }
    
}
