package ar.com.ada.api.pooflixmongo.entities;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="genres")
public class Genre {
    private ObjectId _id;
    private String name;
    private String description;
    private List<ObjectId> directors = new ArrayList<>();
    private List<ObjectId> actors = new ArrayList<>();
    private List<ObjectId> movies = new ArrayList<>();
    private List<ObjectId> series = new ArrayList<>();

    public Genre(){

    }

    public Genre(String name){
        this.name = name;
    }

    public Genre(String name, String description){
        this.name = name;
        this.description = description;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ObjectId> getDirectors() {
        return directors;
    }

    public void setDirectors(List<ObjectId> directors) {
        this.directors = directors;
    }

    public List<ObjectId> getActors() {
        return actors;
    }

    public void setActors(List<ObjectId> actors) {
        this.actors = actors;
    }

    public List<ObjectId> getMovies() {
        return movies;
    }

    public void setMovies(List<ObjectId> movies) {
        this.movies = movies;
    }

    public List<ObjectId> getSeries() {
        return series;
    }

    public void setSeries(List<ObjectId> series) {
        this.series = series;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
