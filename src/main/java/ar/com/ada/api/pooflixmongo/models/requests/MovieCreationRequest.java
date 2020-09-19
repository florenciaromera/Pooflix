package ar.com.ada.api.pooflixmongo.models.requests;

import java.util.*;

public class MovieCreationRequest {
    public String title;
    public String releaseDate;
    public boolean awardWinner;
    public List<String> genre;
    public String director;
    public List<String> actors;    
}
