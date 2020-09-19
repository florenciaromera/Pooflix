package ar.com.ada.api.pooflixmongo.models.responses;

public class GenreResponse {
    public String name;
    public String description;

    public GenreResponse(){

    }

    public GenreResponse(String name, String description){
        this.name = name;
        this.description = description;
    }
}
