package moviepack.models;

import java.util.Comparator;
import java.util.LinkedList;

public class Movie implements Comparable<Movie>{
    private long id;
    private String name;
    private int year;
    private Genre genre;
    private Producer producer;
    private LinkedList<Actor> actors;

    public static Comparator<Movie> comparator1 = new Comparator<Movie>(){

        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    };

    public static Comparator<Movie> comparator2 = new Comparator<Movie>(){

        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.getProducer().getFirstName().compareToIgnoreCase(o2.getProducer().getFirstName());
        }
    };

    public Movie() {
    }

    public Movie(long id, String name, int year, Genre genre, Producer producer, LinkedList<Actor> actors) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.producer = producer;
        this.actors = actors;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public LinkedList<Actor> getActors() {
        return actors;
    }

    public void setActors(LinkedList<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\n' +
                "producer=" + producer +
                "\nactors=" + actors +
                '}';
    }

    @Override
    public int compareTo(Movie o) {
        return this.year - o.year;
    }

}
