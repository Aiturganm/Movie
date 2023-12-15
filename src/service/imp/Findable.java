package service.imp;

import moviepack.database.DataBase;
import moviepack.models.Genre;
import moviepack.models.Movie;

import java.util.LinkedList;
import java.util.List;

public class Findable implements service.Findable {

    private final DataBase dataBase;

    public Findable(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<Movie> getAllMovies() {
        return dataBase.movies;
    }

    @Override
    public Movie findMovieByNameOrPartName(String name) {
        boolean isTrue = true;
        for (int i = 0; i < dataBase.movies.size(); i++) {
            if (dataBase.movies.get(i).getName().equalsIgnoreCase(name)) {
                return dataBase.movies.get(i);
            } else isTrue = false;
        }
        if (isTrue == false){
            System.out.println("Movie with name " + name + " not found!");
        }
        return null;
    }

    @Override
    public void findMovieByActorName(String actorName) {
        boolean isTrue = true;
        for (int i = 0; i < dataBase.movies.size(); i++) {
            for (int j = 0; j < dataBase.movies.get(i).getActors().size(); j++) {
                if (dataBase.movies.get(i).getActors().get(j).getFullName().equalsIgnoreCase(actorName)) {
                    System.out.println(dataBase.movies.get(i));
                } else isTrue = false;
            }
        }
        if (isTrue == false) {
            System.out.println("Movie with actor name " + actorName + " not found!");
        }
    }

    @Override
    public LinkedList<Movie> findMovieByYear(int year) {
        boolean isTrue = true;
        LinkedList<Movie> movies = new LinkedList<>();
        for (int i = 0; i < dataBase.movies.size(); i++) {
            if (dataBase.movies.get(i).getYear() == year) {
                movies.add(dataBase.movies.get(i));
            } else isTrue = false;
        }
        if (isTrue == false) {
            System.out.println("Movie with year " + year + " not found!");
        }
        return movies;
    }

    @Override
    public void findMovieByProducer(String producerName) {
        boolean isTrue = true;
        for (int i = 0; i < dataBase.movies.size(); i++) {
            if (dataBase.movies.get(i).getProducer().getFirstName().equalsIgnoreCase(producerName)) {
                System.out.println(dataBase.movies.get(i));
            } else isTrue = false;
        }
        if (isTrue == false) {
            System.out.println("Movie with producer name " + producerName + " not found!");
        }
    }

    @Override
    public LinkedList<Movie> findMovieByGenre(String genre) {
        boolean isTrue = true;
        LinkedList<Movie> list = new LinkedList<>();
        for (int i = 0; i < dataBase.movies.size(); i++) {
            if (dataBase.movies.get(i).getGenre().getGenre().equalsIgnoreCase((genre))){
                list.add(dataBase.movies.get(i));
            } else isTrue = false;
        }
        if (isTrue == false) {
            System.out.println("Movie with genre " + genre + " not found!");
        }
        return list;
    }

    @Override
    public void findMovieByRole(String role) {
        boolean isTrue = true;
        for (int i = 0; i < dataBase.movies.size(); i++) {
            for (int j = 0; j < dataBase.movies.get(i).getActors().size(); j++) {
                if(dataBase.movies.get(i).getActors().get(j).getRole().equalsIgnoreCase(role)){
                    System.out.println(dataBase.movies.get(i));
                }else isTrue = false;
            }
        }
        if(isTrue == false){
            System.out.println("Movie with role " + role + " not found!");
        }
    }
}
