package ar.com.ada.api.pooflixmongo.repos;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.pooflixmongo.entities.Directress;


@Repository
public interface DirectressRepo extends MongoRepository<Directress, ObjectId> {
    Directress findBy_id(ObjectId _id);

    @Query("{ 'name' : ?0 }")
    Optional<Directress> findDirectressByName(String name);
}
