package moviepack;

import moviepack.database.DataBase;
import moviepack.models.Actor;
import moviepack.models.Genre;
import moviepack.models.Movie;
import moviepack.models.Producer;
import service.Findable;
import service.Sortable;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataBase dataBase = new DataBase();
        Findable findable = new service.imp.Findable(dataBase);
        Sortable sortable = new service.imp.Sortable(dataBase);
        LinkedList<Movie> list = new LinkedList<>();
        long idMov = 1;
        long idAct = 1;
        long idProd = 1;
        list.add(new Movie(idMov++, "Shawshank Redemption", 1994, new Genre("Drama"), new Producer(idProd++, "Niki", "Marvin"), new LinkedList<Actor>(Arrays.asList(new Actor(idAct++, "Tim Robbins", "Andy Dufresne"), new Actor(idAct++, "Morgan Freeman", "Ellis Boyd Redding")))));
        list.add(new Movie(idMov++, "The Dark Knignt", 2008, new Genre("Crime"), new Producer(idProd++, "Christopher", "Nolan"), new LinkedList<Actor>(Arrays.asList(new Actor(idAct++, "Christian Bale", "Bruce Wayne"), new Actor(idAct++, "Heath Ledger", "Joker")))));
        list.add(new Movie(idMov++, "Pulp Fiction", 1994, new Genre("Drama"), new Producer(idProd++, "Lawrence", "Bender"), new LinkedList<Actor>(Arrays.asList(new Actor(idAct++, "John Travolta", "Vincet Vega"), new Actor(idAct++, "Uma Thurman", "Mia Wallace")))));
        list.add(new Movie(idMov++, "Schindler's List", 1993, new Genre("History"), new Producer(idProd++, "Steven", "Spielberg"), new LinkedList<Actor>(Arrays.asList(new Actor(idAct++, "Liam Neeson", "Oskar Schindler"), new Actor(idAct++, "Ben Kingsley", "Itzhak Stern")))));
        list.add(new Movie(idMov++, "Inception", 2010, new Genre("Action"), new Producer(idProd++, "Emma", "Thomas"), new LinkedList<Actor>(Arrays.asList(new Actor(idAct++, "Leonardo DiCaprio", "Dom Cobb"), new Actor(idAct++, "Joseph Gordon-Levitt", "Arthur")))));
        list.add(new Movie(idMov++, "Titanic", 1997, new Genre("Romance"), new Producer(idProd++, "James", "Cameron"), new LinkedList<Actor>(Arrays.asList(new Actor(idAct++, "Leonardo DiCaprio", "Jack Dawson"), new Actor(idAct++, "Kate Winslet", "Rose DeWitt Bukater")))));
        dataBase.movies = list;
        for (Movie movie : list) {
            System.out.println(movie + "\n");
        }
        Loop:
        while (true) {
            System.out.println("""
                    1. GET ALL MOVIES
                    2. FIND MOVIE BY NAME
                    3. FIND MOVIE BY ACTOR NAME
                    4. FIND MOVIE BY YEAR
                    5. FIND MOVIE BY PRODUCER
                    6. FIND MOVIE BY GENRE
                    7. FIND MOVIE BY ROLE
                    8. SORT BY MOVIE NAME
                    9. SORT BY YEAR
                    10. SORT BY PRODUCER
                    """);
            switch (scanner.nextLine().toLowerCase()) {
                case "1" -> {
                    for (Movie allMovie : findable.getAllMovies()) {
                        System.out.println(allMovie + "\n");
                    }
                }
                case "2" -> {
                    System.out.println("Enter movie name: ");
                    System.out.println(findable.findMovieByNameOrPartName(scanner.nextLine()));
                }
                case "3" -> {
                    System.out.println("Enter actor name: ");
                    findable.findMovieByActorName(scanner.nextLine());
                }
                case "4" -> {
                    System.out.println("Enter year: ");
                    LinkedList<Movie> movieByYear = findable.findMovieByYear(new Scanner(System.in).nextInt());
                    for (Movie movie : movieByYear) {
                        System.out.println(movie + "\n");
                    }

                }
                case "5" -> {
                    System.out.println("Enter producer name: ");
                    findable.findMovieByProducer(scanner.nextLine());
                }
                case "6" -> {
                    System.out.println("Enter genre: ");
                    LinkedList<Movie> movieByGenre = findable.findMovieByGenre(scanner.nextLine());
                    for (Movie movie : movieByGenre) {
                        System.out.println(movie + "\n");
                    }
                }
                case "7" -> {
                    System.out.println("Enter role: ");
                    findable.findMovieByRole(scanner.nextLine());
                }
                case "8" -> {
                    System.out.println("Asc or desc: ");
                    LinkedList<Movie> list1 = sortable.sortByMovieName(scanner.nextLine());
                    for (Movie movie : list1) {
                        System.out.println(movie.getName() + " -> " + movie + "\n");
                    }
                }
                case "9" -> {
                    System.out.println("Asc or desc: ");
                    sortable.sortByYear(scanner.nextLine());
                }
                case "10" -> {
                    for (Movie movie : sortable.sortByProducer()) {
                        System.out.println(movie.getProducer() + " -> \n" + movie + "\n");
                    }
                }

            }
        }
    }
}