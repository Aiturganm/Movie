package service.imp;

import moviepack.database.DataBase;
import moviepack.models.Movie;
import java.util.Collections;
import java.util.LinkedList;

public class Sortable implements service.Sortable {
    private final DataBase dataBase;

    public Sortable(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public LinkedList<Movie> sortByMovieName(String ascOrDesc) {
        if(ascOrDesc.equalsIgnoreCase("asc")){
            dataBase.movies.sort(Movie.comparator1);
            return dataBase.movies;
        }else if (ascOrDesc.equalsIgnoreCase("desc")){
            dataBase.movies.sort(Movie.comparator1);
            LinkedList<Movie> list = new LinkedList<>();
            for (int i = dataBase.movies.size()-1; i >= 0; i--) {
                list.add(dataBase.movies.get(i));
            }
            return list;
        }
        return null;
    }

    @Override
    public void sortByYear(String ascOrDesc) {
        if(ascOrDesc.equalsIgnoreCase("asc")) {
            Collections.sort(dataBase.movies);
            for (Movie movie : dataBase.movies) {
                System.out.println(movie.getYear() + " -> " + movie + "\n");
            }
        }else if(ascOrDesc.equalsIgnoreCase("desc")){
            LinkedList<Movie> newLinkedList = new LinkedList<>();
            Collections.sort(dataBase.movies);
            for (int i = dataBase.movies.size()-1; i >= 0; i--) {
                newLinkedList.add(dataBase.movies.get(i));
            }
            for (Movie movie : newLinkedList) {
                System.out.println(movie.getYear() + " -> " + movie + "\n");
            }
        }
    }

    @Override
    public LinkedList<Movie> sortByProducer() {
        dataBase.movies.sort(Movie.comparator2);
        return dataBase.movies;
    }
}
