package ar.com.ada.api.pooflixmongo.services;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.pooflixmongo.entities.Series;
import ar.com.ada.api.pooflixmongo.repos.SeriesRepo;

@Service
public class SeriesService {
    @Autowired
    SeriesRepo sR;

    public Optional<Series> seriesExistsById(ObjectId _id) {
        return Optional.of(sR.findBy_id(_id));
    }

    public Optional<Series> createSeries(String title, Date releaseDate, boolean awardWinner, String genre) {
        Optional<Series> seriesOp = sR.findSeriesByTitle(title);
        return seriesOp.isPresent() ? Optional.of(sR.save(new Series(title, releaseDate, awardWinner, genre)))
                : Optional.empty();
    }

    public Optional<Series> getSeriesById(ObjectId id) {
        Optional<Series> seriesOp = seriesExistsById(id);
        return seriesOp.isPresent() ? seriesOp : Optional.empty();
    }

    public Optional<Series> getSeriesByTitle (String title) {
        Optional<Series> seriesOp = sR.findSeriesByTitle(title);
        return seriesOp.isPresent() ? seriesOp : Optional.empty();
    }    
}
