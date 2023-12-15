package moviepack.database;

import moviepack.models.Actor;
import moviepack.models.Genre;
import moviepack.models.Movie;
import moviepack.models.Producer;

import java.util.LinkedList;

public class DataBase {
    public LinkedList<Movie> movies;
    public LinkedList<Actor> actors;
    public LinkedList<Producer> producers;
    public LinkedList<Genre> genres;
}
