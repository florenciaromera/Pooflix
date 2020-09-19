package ar.com.ada.api.pooflixmongo.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;

import ar.com.ada.api.pooflixmongo.entities.Movie;
import ar.com.ada.api.pooflixmongo.services.ActressService;
import ar.com.ada.api.pooflixmongo.services.DirectressService;
import ar.com.ada.api.pooflixmongo.services.GenreService;

public class MovieAfterSaveListener extends AbstractMongoEventListener<Movie> {
    @Autowired
    GenreService genreService;

    @Autowired
    DirectressService directressService;

    @Autowired
    ActressService actressService;

    @Override
    public void onAfterSave(AfterSaveEvent<Movie> event) {
        super.onAfterSave(event);
        Movie movie = event.getSource();

        actressService.addOrEditActressFromListener(movie.get_id(), movie.getActresses());
        directressService.addOrEditDirectressFromListener(movie.get_id(), movie.getDirectress());
        genreService.addOrEditGenreFromListener(movie.get_id(), movie.getGenres());
    }
}
