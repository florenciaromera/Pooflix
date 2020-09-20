package ar.com.ada.api.pooflixmongo.models.responses;

import java.util.List;

import ar.com.ada.api.pooflixmongo.entities.Season;

public class SeriesResponse {
    public String title;
    public String releaseDate;
    public List<String> genres;
    public List<Season> seasons;

    public SeriesResponse(){

    }

    public SeriesResponse(String title, String releaseDate, List<String> genres, List<Season> seasons){
        this.title = title;
        this.releaseDate = releaseDate;
        this.genres = genres;
        this.seasons = seasons;
    }
}
