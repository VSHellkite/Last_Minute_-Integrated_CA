package backend.sevices;


import backend.Interface;
import backend.models.Movie;
import backend.repository.Database;
import backend.repository.UsersMoviesRepository;
import backend.repository.UsersMoviesRepositoryImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class RentMovie {
    


    public int id;
    private String originalLenguage;
    private String originalTitle;
    private String overwiew;
    private double popularity;
    private String releaseDate;
    private int runtime;
    private String tag;
    private String title;
    private double voteAvg;
    private int voteCount;
    private double price;

    Scanner scanner = new Scanner(System.in);
    private int answ = 0;


    public void main(Movie thisMovie) {

        id = thisMovie.getId();
        originalLenguage = thisMovie.getOriginalLenguage();
        originalTitle = thisMovie.getOriginalTitle();
        overwiew = thisMovie.getOverwiew();
        popularity = thisMovie.getPopularity();
        releaseDate = thisMovie.getReleaseDate();
        runtime = thisMovie.getRuntime();
        tag = thisMovie.getTag();
        title = thisMovie.getTitle();
        voteAvg = thisMovie.getVoteAvg();
        voteCount = thisMovie.getVoteCount();
        price = thisMovie.getPrice();

        presentMovie();
        System.out.println("That is the movie you have picked.");
        System.out.println(title);
        System.out.println(tag);
        System.out.println(popularity);
        System.out.println(runtime);
        System.out.println(originalLenguage);
        System.out.println(originalTitle);
        System.out.println(releaseDate);
        System.out.println(overwiew);
        System.out.println(releaseDate);
        System.out.println(voteAvg);
        System.out.println(voteCount);
        System.out.println(price);


    }


    private void presentMovie() {
        System.out.println("That is the movie you have picked.");
        System.out.println(title);
        System.out.println("If you wish to rent it, press '1'");
        System.out.println("if you wish to see more information, press '2'");
        System.out.println("to keep browsing press 3");
        answ = scanner.nextInt();

        switch (answ) {
            case 1:
                rent();
            case 2:
                seeMoreInfo();
            //case 3: thisInterface.lookForMovies();
        }
    }


    private void rent() {
        System.out.println(title);
        System.out.println(price + '$');

        System.out.println("Do you wish to rent this movie?");
        System.out.println("If yes, press '1'");
        System.out.println("If no press '2'");

        answ = scanner.nextInt();

        switch (answ) {
            case 1:
                rentMovie();
            case 2:
                presentMovie();

        }

    }


    private void seeMoreInfo() {

        System.out.println("Tittle: " + title);
        System.out.println("Tags" + tag);
        System.out.println("Popularity:" + popularity);
        System.out.println("Movie is: " + runtime + " munites long");
        System.out.println("originaly filmed in '" + originalLenguage + "' lengage");
        System.out.println("originally named:" + originalTitle);
        System.out.println("released on: " + releaseDate);
        System.out.println(overwiew);
        System.out.println("Average Vote: " + voteAvg);
        System.out.println("Number of people voted on this movie: " + voteCount);
        System.out.println(price + '$');

        System.out.println("");
        System.out.println("");

        System.out.println("Do you wish to rent it?");
        System.out.println("If you do, press '1'");
        System.out.println("If no, press '2'");
        answ = scanner.nextInt();
        switch (answ) {
            case 1:
                rent();
            case 2:
                break;
        }

    }


    private void rentMovie() {
        System.out.println("How do you rate this movie from 1 to 10?");
        int userRate = scanner.nextInt();
        int userId = Interface.loggedInUser.getUserid();
        
        UsersMoviesRepository repository = new UsersMoviesRepositoryImpl();
        repository.rentMovie(userId, id, title, userRate);
    }


}
