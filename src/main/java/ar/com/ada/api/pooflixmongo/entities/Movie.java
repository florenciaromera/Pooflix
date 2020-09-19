package ar.com.ada.api.pooflixmongo.entities;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movies")
public class Movie extends MediaContent {
    private ObjectId _id;
    private String title;
    private String releaseDate;
    private boolean awardWinner;
    private List<String> genres = new ArrayList<>();
    private String directress;
    private List<String> actresses = new ArrayList<>();

    public Movie() {

    }

    public Movie(String title, String releaseDate, boolean awardWinner, List<String> genres, String directress,
            List<String> actresses) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.awardWinner = awardWinner;
        this.genres = genres;
        this.directress = directress;
        this.actresses = actresses;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAwardWinner() {
        return awardWinner;
    }

    public void setAwardWinner(boolean awardWinner) {
        this.awardWinner = awardWinner;
    }

    public String getDirectress() {
        return directress;
    }

    public void setDirectress(String directress) {
        this.directress = directress;
    }

    public List<String> getActresses() {
        return actresses;
    }

    public void setActresses(List<String> actresses) {
        this.actresses = actresses;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

}
