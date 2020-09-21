package ar.com.ada.api.pooflixmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

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

	/**
	 * Agregue esto para que ejecuten eventos en distintos threads y el postman no se me quede colgado 5 horas (gracias stackoverflow)
	 * @return
	 * 
	 */
	/*
	@Bean(name = "applicationEventMulticaster")
	public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
		SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
		SimpleAsyncTaskExecutor executor = new SimpleAsyncTaskExecutor();
		eventMulticaster.setTaskExecutor(executor);
		return eventMulticaster;
	}*/
}
