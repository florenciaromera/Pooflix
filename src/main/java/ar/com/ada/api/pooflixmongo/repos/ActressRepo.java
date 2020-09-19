package ar.com.ada.api.pooflixmongo.repos;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.pooflixmongo.entities.Actress;

@Repository
public interface ActressRepo extends MongoRepository<Actress, ObjectId> {
    Actress findBy_id(ObjectId _id);

    @Query("{ 'name' : ?0 }")
    Optional<Actress> findActressByName(String name);
}
