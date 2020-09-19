package ar.com.ada.api.pooflixmongo.entities;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "series")
public class Series extends MediaContent {
    private ObjectId _id;
    private String title;
    private Date releaseDate;
    private boolean awardWinner;
    private String genre;
    private List<Season> seasons = new ArrayList<>();

    public Series(){

    }

    public Series(String title, Date releaseDate, boolean awardWinner, String genre){

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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isAwardWinner() {
        return awardWinner;
    }

    public void setAwardWinner(boolean awardWinner) {
        this.awardWinner = awardWinner;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }
}
