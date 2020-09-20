package ar.com.ada.api.pooflixmongo.models.requests;

import java.util.List;

public class SeriesCreationRequest {
    public String title;
    public String releaseDate;
    public boolean awardWinner;
    public List<String> genre;
}
