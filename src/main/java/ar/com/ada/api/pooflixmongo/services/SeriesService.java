package ar.com.ada.api.pooflixmongo.services;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.ReplaceRootOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import ar.com.ada.api.pooflixmongo.entities.Episode;
import ar.com.ada.api.pooflixmongo.entities.Series;
import ar.com.ada.api.pooflixmongo.repos.SeriesRepo;

@Service
public class SeriesService {
    @Autowired
    SeriesRepo seriesRepo;

    // accede directo a mongodb
    @Autowired
    MongoTemplate mongoTemplate;

    public Optional<Series> seriesExistsById(ObjectId _id) {
        return Optional.of(seriesRepo.findBy_id(_id));
    }

    public Optional<Series> createSeries(String title, Date releaseDate, boolean awardWinner, String genre) {
        Optional<Series> seriesOp = seriesRepo.findSeriesByTitle(title);
        return seriesOp.isPresent() ? Optional.of(seriesRepo.save(new Series(title, releaseDate, awardWinner, genre)))
                : Optional.empty();
    }

    public Optional<Series> getSeriesById(ObjectId id) {
        Optional<Series> seriesOp = seriesExistsById(id);
        return seriesOp.isPresent() ? seriesOp : Optional.empty();
    }

    public Optional<Series> getSeriesByTitle(String title) {
        Optional<Series> seriesOp = seriesRepo.findSeriesByTitle(title);
        return seriesOp.isPresent() ? seriesOp : Optional.empty();
    }

    public Optional<Episode> getEpisode(ObjectId id, Integer seasonNumber, Integer episodeNumber) {
        MatchOperation matchSeriesStage = Aggregation.match(new Criteria("_id").is(id));
        ProjectionOperation projectSeasonStage = Aggregation.project("seasons");
        UnwindOperation unwindSeasonStage = Aggregation.unwind("seasons");
        MatchOperation matchSeasonStage = Aggregation.match(new Criteria("seasons.number").is(seasonNumber));
        ReplaceRootOperation replaceRootSeasonStage = Aggregation.replaceRoot("seasons");
        UnwindOperation unwindEpisodeStage = Aggregation.unwind("episodes");
        ReplaceRootOperation replaceRootEpisodeStage = Aggregation.replaceRoot("episodes");
        MatchOperation matchEpisodeStage = Aggregation.match(new Criteria("number").is(episodeNumber));
        Aggregation aggregation = Aggregation.newAggregation(matchSeriesStage, projectSeasonStage, unwindSeasonStage,
                matchSeasonStage, replaceRootSeasonStage, unwindEpisodeStage, replaceRootEpisodeStage,
                matchEpisodeStage);
        AggregationResults<Episode> result = mongoTemplate.aggregate(aggregation, "series", Episode.class);
        Episode episode = result.getUniqueMappedResult();
        return Optional.of(episode);
    }
}
