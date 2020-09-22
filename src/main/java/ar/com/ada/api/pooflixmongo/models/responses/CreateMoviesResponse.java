package ar.com.ada.api.pooflixmongo.models.responses;

public class CreateMoviesResponse {
    public String message;
    public boolean isOk;

    public CreateMoviesResponse(){

    }

    public CreateMoviesResponse(String message, boolean isOk){
        this.message = message;
        this.isOk = isOk;
    }
}
