package service;

import moviepack.models.Movie;

import javax.swing.*;
import java.util.Comparator;
import java.util.LinkedList;

public interface Sortable {
    LinkedList<Movie> sortByMovieName(String ascOrDesc);
    void sortByYear(String ascOrDesc);
    LinkedList<Movie> sortByProducer();

}
