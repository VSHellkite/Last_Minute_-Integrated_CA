package backend;

import java.util.Scanner;
import backend.models.User;
import backend.Sevices.UserServiceImpl;
import backend.models.Movie;
import backend.models.UsersMovies;
import backend.repository.MovieRepositoryImpl;
import backend.repository.UsersMoviesRepositoryImpl;
import backend.sevices.DropMovies;
import backend.sevices.DropUsersMovies;
import backend.sevices.RentMovie;
import java.util.ArrayList;
import java.util.List;


public class Interface {
    

    private static final Scanner scanner = new Scanner(System.in);
    private static final UserServiceImpl userService = new UserServiceImpl();
    public static User loggedInUser = null;
    private String answ = "";
    public int userColumnAmount = 10;
    public int offset = 0;
    DropMovies thisDropMovies = new DropMovies();
    DropUsersMovies thisDropUsersMovies = new DropUsersMovies();
    List<Movie> currentMovieList = new ArrayList<>();
    MovieRepositoryImpl thisMovieRepositoryImpl = new MovieRepositoryImpl();
    UsersMoviesRepositoryImpl thisUMRimpl = new UsersMoviesRepositoryImpl();
    RentMovie thisRentMovie = new RentMovie();
    List<UsersMovies> thisUsersMovies = new ArrayList<>();

    public int getUserColumnAmount() {
        return userColumnAmount;
    }
            
            

    private void login() {
                System.out.print("LOGIN: ");
        String loginUsername = scanner.nextLine();
        System.out.print("PASSWORD: ");
        String loginPassword = scanner.nextLine();
        loggedInUser = userService.login(loginUsername, loginPassword);
        if (loggedInUser != null) {
            System.out.println("Welcome " + loggedInUser.getUsername());
            mainMenu();

        } else {
            System.out.println("No such user found. Try again");
        }
    
    }

private void createUser() {

        String username = null;
        String password = null;
        String login = null;
        System.out.print("Enter your login: ");
        login = scanner.nextLine();
        System.out.print("Enter your password: ");
            password = scanner.nextLine();
    System.out.print("Enter your username: ");
            username = scanner.nextLine();
        User newUser = new User(2, login, password, username);
        User result = userService.createUser(newUser);
        if (result != null) {
            System.out.println("New accout for " + result.getUsername() + " has been created. You may login now");
            main();
        }
    }

    private void mainMenu() {
        Prompt.MainMenu();
        answ = scanner.nextLine();
        
        switch(Integer.parseInt(answ)){
            case 1: userMovieList();
            case 2: lookForMovies();
            case 3: main(); 
            case 4: settings();
            case 5: System.exit(0);
        }
        
    }

    public void lookForMovies() {
        Prompt.MovieSearchMethod();
        answ = scanner.nextLine();
        switch(Integer.parseInt(answ)){
            case 1:
                currentMovieList = thisDropMovies.drop("popularity", userColumnAmount, offset);
                thisMovieRepositoryImpl.listMovies(currentMovieList);
                keepLooking("popularity");
            case 2:
                currentMovieList = thisDropMovies.drop("voteAvg", userColumnAmount, offset);
                thisMovieRepositoryImpl.listMovies(currentMovieList);
                keepLooking("voteAvg");
            case 3:
                currentMovieList = thisDropMovies.drop("voteCount", userColumnAmount, offset);
                thisMovieRepositoryImpl.listMovies(currentMovieList);
                keepLooking("voteCount");
            case 4:
                currentMovieList = thisDropMovies.drop("shortest", userColumnAmount, offset);
                thisMovieRepositoryImpl.listMovies(currentMovieList);
                keepLooking("shortest");
            case 5:
                currentMovieList = thisDropMovies.drop("longest", userColumnAmount, offset);
                thisMovieRepositoryImpl.listMovies(currentMovieList);
                keepLooking("longest");
            case 6:
                mainMenu();
        }
    }
        private void keepLooking(String option) {
            Prompt.keepLooking();
            answ = scanner.nextLine();
            
            if("y".equalsIgnoreCase(answ)){
                offset ++;
                thisDropMovies.drop(option,userColumnAmount, offset);
                keepLooking(option);
            }
            else if("s".equalsIgnoreCase(answ)){
                lookForMovies();
            }
            else if("b".equalsIgnoreCase(answ)){
            mainMenu();
            }
            else{
            } 
            thisRentMovie.main(currentMovieList.get(Integer.parseInt(answ)));
            
    }
    
    
    
    
    
    public void main() {
        
        Prompt.InitaialStatments();
        answ = scanner.nextLine();
        switch(Integer.parseInt(answ)){
            case 1: login();
            case 2: createUser();
            case 3: System.exit(0); 
        }


        



    }
    private void settings() {
        System.out.println("Movies column amount is set for: " + userColumnAmount);
        System.out.println("Do you wish to change it?");
        System.out.println("If yes - press 'y'");
        System.out.println("If no - press 'n'");
        answ = scanner.nextLine().toLowerCase();
        switch(answ){
            case "y":
                System.out.println("How many columns Do you wish to deop?");
                userColumnAmount = scanner.nextInt();
                System.out.println("New columns amount is set for: " + userColumnAmount);
            case "n":mainMenu();
    }

    }

    private void userMovieList() {
        System.out.println("Here are movies, that you have rented: ");
        thisUsersMovies = thisDropUsersMovies.drop(loggedInUser.getUserid());
        thisUMRimpl.listMovies(thisUsersMovies);
        mainMenu();
        
    
    }
}
