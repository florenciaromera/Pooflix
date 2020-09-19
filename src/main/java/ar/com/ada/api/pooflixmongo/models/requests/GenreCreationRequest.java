package ar.com.ada.api.pooflixmongo.models.requests;

public class GenreCreationRequest {
    public String name;
    public String description;

    public GenreCreationRequest(){

    }

    public GenreCreationRequest(String name, String description){
        this.name = name;
        this.description = description;
    }
}
