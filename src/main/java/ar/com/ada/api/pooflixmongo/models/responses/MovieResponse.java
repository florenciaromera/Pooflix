package ar.com.ada.api.pooflixmongo.models.responses;

public class MovieResponse {
    public String title;
    public String releaseDate;
    public boolean awardWinner;

    public MovieResponse(){

    }

    public MovieResponse(String title, String releaseDate, boolean awardWinner){
        this.title = title;
        this.releaseDate = releaseDate;
        this.awardWinner = awardWinner;
    }
}
