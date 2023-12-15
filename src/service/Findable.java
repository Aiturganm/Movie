package service;

import moviepack.models.Genre;
import moviepack.models.Movie;

import java.time.Year;
import java.util.LinkedList;
import java.util.List;

public interface Findable {
    List<Movie> getAllMovies();
    Movie findMovieByNameOrPartName(String name);
    void findMovieByActorName(String actorName);
    LinkedList<Movie> findMovieByYear(int year);
    void findMovieByProducer(String producerName);
    LinkedList<Movie> findMovieByGenre(String genre);
    void findMovieByRole(String role);

}
