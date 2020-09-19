package ar.com.ada.api.pooflixmongo.entities;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="directress")
public class Directress {
    private ObjectId _id;
    private String name;
    private String nationality;
    private Date birthDate;
    private List<ObjectId> movies = new ArrayList<>();
    private List<ObjectId> series = new ArrayList<>();

    public Directress(){

    }

    public Directress(String name){
        this.name = name;
    }

    public Directress(String name, Date birthDate, String nationality){
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}
