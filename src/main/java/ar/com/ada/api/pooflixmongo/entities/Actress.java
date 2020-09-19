package ar.com.ada.api.pooflixmongo.entities;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "actresses")
public class Actress {
    private ObjectId _id;
    private String name;
    private Date birthDate;
    private String nationality;
    private List<ObjectId> moviesId = new ArrayList<>();
    private List<ObjectId> seriesId = new ArrayList<>();

    public Actress() {

    }

    public Actress(String name){
        this.name = name;
    }
    public Actress(String name, Date birthDate, String nationality) {
        this.name = name;
        this.birthDate = birthDate;
        this.nationality = nationality;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<ObjectId> getMovies() {
        return moviesId;
    }

    public void setMovies(List<ObjectId> movies) {
        this.moviesId = movies;
    }

    public List<ObjectId> getSeries() {
        return seriesId;
    }

    public void setSeries(List<ObjectId> series) {
        this.seriesId = series;
    }

}
