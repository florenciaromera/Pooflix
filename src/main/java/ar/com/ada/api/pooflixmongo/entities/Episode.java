package ar.com.ada.api.pooflixmongo.entities;

import java.util.*;

import org.bson.types.ObjectId;

public class Episode {
    private ObjectId _id;
    private String title;
    private Integer number;
    private Date releaseDate;
    private ObjectId directressId;
    private List<String> actresses;

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

    public ObjectId getDirectressId() {
        return directressId;
    }

    public void setDirectressId(ObjectId directressId) {
        this.directressId = directressId;
    }

    public List<String> getActresses() {
        return actresses;
    }

    public void setActresses(List<String> actressesId) {
        this.actresses = actressesId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
