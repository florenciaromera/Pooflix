package ar.com.ada.api.pooflixmongo.controllers;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.pooflixmongo.entities.Series;
import ar.com.ada.api.pooflixmongo.models.requests.SeriesCreationRequest;
import ar.com.ada.api.pooflixmongo.models.requests.SeriesCreationRequestList;
import ar.com.ada.api.pooflixmongo.models.responses.EpisodeResponse;
import ar.com.ada.api.pooflixmongo.models.responses.SeriesResponse;
import ar.com.ada.api.pooflixmongo.services.SeriesService;

@RestController
public class SeriesController {
    @Autowired
    SeriesService seriesService;

    @PostMapping("/api/series/batches")
    public ResponseEntity<?> createSeries(@RequestBody SeriesCreationRequestList seriesCreationRequestList) {
        for (SeriesCreationRequest s : seriesCreationRequestList.getSeriesCreationRequest()) {
            seriesService.createSeries(s.title, s.releaseDate, s.awardWinner, s.genre);
        }
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/api/series/{id}")
    public ResponseEntity<SeriesResponse> getSeriesById(@PathVariable ObjectId id) {
        Optional<Series> seriesOp = seriesService.getSeriesById(id);
        return seriesOp.isPresent() ? ResponseEntity.ok(new SeriesResponse(seriesOp.get().getTitle(),
                seriesOp.get().getReleaseDate(), seriesOp.get().getGenres(), seriesOp.get().getSeasons()))
                : ResponseEntity.badRequest().build();
    }

    @GetMapping("/api/series/{id}/episodes/{seasonNumber}-{episodeNumber}")
    public ResponseEntity<EpisodeResponse> getEpisode(@PathVariable ObjectId id, @PathVariable Integer seasonNumber,
            @PathVariable Integer episodeNumber) {
        seriesService.getEpisode(id, seasonNumber, episodeNumber);
        return ResponseEntity.ok(new EpisodeResponse());
    }
}
