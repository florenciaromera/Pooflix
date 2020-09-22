package ar.com.ada.api.pooflixmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ar.com.ada.api.pooflixmongo.listeners.MovieAfterSaveListener;

@SpringBootApplication
public class PooflixmongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PooflixmongoApplication.class, args);
	}

	@Bean
	public MovieAfterSaveListener movieAfterSaveListener() {
		return new MovieAfterSaveListener();
	}
}
