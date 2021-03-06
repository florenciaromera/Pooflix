package ar.com.ada.api.pooflixmongo.repos;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.pooflixmongo.entities.Movie;

@Repository
public interface MovieRepo extends MongoRepository<Movie, ObjectId> {
    Movie findBy_id(ObjectId _id);

    @Query("{ 'title' : ?0 }")
    Optional<Movie> findMovieByTitle(String title);

    // @Query(value = "{ 'actress._id' : ?0 }", fields = "{'_id' : 1, 'title': 1, 'actress' : 1 }")
    // List<Movie> findMoviesByActress_id(ObjectId _id);
}
