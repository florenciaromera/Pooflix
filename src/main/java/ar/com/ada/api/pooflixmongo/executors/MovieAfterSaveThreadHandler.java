package ar.com.ada.api.pooflixmongo.executors;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.ada.api.pooflixmongo.entities.Movie;
import ar.com.ada.api.pooflixmongo.services.ActressService;
import ar.com.ada.api.pooflixmongo.services.DirectressService;
import ar.com.ada.api.pooflixmongo.services.GenreService;

@Component
public class MovieAfterSaveThreadHandler {
    @Autowired
    GenreService genreService;

    @Autowired
    DirectressService directressService;

    @Autowired
    ActressService actressService;

    public void handle(Movie movie) {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(() -> {
            Date init = new Date();
            actressService.addOrEditActressFromListener(movie.get_id(), movie.getActresses());
            Date finish = new Date();
            long timeDiff = finish.getTime() - init.getTime();
            return Thread.currentThread().getName() + " executed, duration " + timeDiff + " in Milliseconds";
        }, () -> {
            Date init = new Date();
            directressService.addOrEditDirectressFromListener(movie.get_id(), movie.getDirectress());
            Date finish = new Date();
            long timeDiff = finish.getTime() - init.getTime();
            return Thread.currentThread().getName() + " executed, duration " + timeDiff + " in Milliseconds";
        }, () -> {
            Date init = new Date();
            genreService.addOrEditGenreFromListener(movie.get_id(), movie.getGenres());
            Date finish = new Date();
            long timeDiff = finish.getTime() - init.getTime();
            return Thread.currentThread().getName() + " executed, duration " + timeDiff + " in Milliseconds";
        });

        try {
            executor.invokeAll(callables).stream().map(future -> {
                try {
                    return future.get();
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }).forEach(System.out::println);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        finally{
            executor.shutdown();
        }
    }
}
