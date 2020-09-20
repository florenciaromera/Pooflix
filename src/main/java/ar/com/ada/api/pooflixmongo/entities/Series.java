package ar.com.ada.api.pooflixmongo.entities;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "series")
public class Series extends MediaContent {
    private ObjectId _id;
    private String title;
    private String releaseDate;
    private boolean awardWinner;
    private List<String> genres = new ArrayList<>();
    private List<Season> seasons = new ArrayList<>();

    public Series(){

    }

    public Series(String title, String releaseDate, boolean awardWinner, List<String> genres){
        this.title = title;
        this.releaseDate = releaseDate;
        this.awardWinner = awardWinner;
        this.genres = genres;
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isAwardWinner() {
        return awardWinner;
    }

    public void setAwardWinner(boolean awardWinner) {
        this.awardWinner = awardWinner;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }    
}
