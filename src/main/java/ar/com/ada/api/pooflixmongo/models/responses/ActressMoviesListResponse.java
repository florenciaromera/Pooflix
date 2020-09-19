package ar.com.ada.api.pooflixmongo.models.responses;

import java.util.List;

import ar.com.ada.api.pooflixmongo.entities.Movie;

public class ActressMoviesListResponse {
    public String fullName; 
    public List<Movie> movies;

    public ActressMoviesListResponse(){

    }
    public ActressMoviesListResponse(String fullName, List<Movie> movies){
        this.fullName = fullName;
        this.movies = movies;
    }
}
