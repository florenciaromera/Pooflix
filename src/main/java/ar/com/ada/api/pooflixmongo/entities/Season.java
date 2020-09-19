package ar.com.ada.api.pooflixmongo.entities;

import java.util.*;

import org.bson.types.ObjectId;

public class Season {
    private ObjectId _id;
    private String title;
    private Integer number;
    private Date releaseDate;
    private List<Episode> episodes = new ArrayList<>();
    private List<Webisode> webisodes = new ArrayList<>();

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public List<Webisode> getWebisodes() {
        return webisodes;
    }

    public void setWebisodes(List<Webisode> webisodes) {
        this.webisodes = webisodes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
