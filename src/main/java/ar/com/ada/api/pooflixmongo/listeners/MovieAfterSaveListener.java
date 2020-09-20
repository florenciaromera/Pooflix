package ar.com.ada.api.pooflixmongo.listeners;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;

import ar.com.ada.api.pooflixmongo.entities.Movie;
import ar.com.ada.api.pooflixmongo.executors.MovieAfterSaveThreadHandler;

public class MovieAfterSaveListener extends AbstractMongoEventListener<Movie> {
    @Autowired
    MovieAfterSaveThreadHandler movieAfterSaveThreadHandler;

    @Override
    public void onAfterSave(AfterSaveEvent<Movie> event) {
        super.onAfterSave(event);
        Movie movie = event.getSource();
        movieAfterSaveThreadHandler.handle(movie);

        System.out.println(new Date().toString());
    }
}
