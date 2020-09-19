package ar.com.ada.api.pooflixmongo.repos;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.pooflixmongo.entities.Series;

@Repository
public interface SeriesRepo extends MongoRepository<Series, ObjectId> {
    Series findBy_id(ObjectId _id);

    @Query("{ 'title' : ?0 }")
    Optional<Series> findSeriesByTitle(String title);
}
