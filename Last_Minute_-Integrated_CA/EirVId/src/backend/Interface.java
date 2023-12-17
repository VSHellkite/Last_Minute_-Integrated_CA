package backend;

import java.util.Scanner;
import backend.User;


public class Interface {

    private static final Scanner scanner = new Scanner(System.in);
        private static final UserServiceImpl userService = new UserServiceImpl();

    private User loggedInUser = null;

    public static void main() {

        System.out.println("Wellcome. Do you have an accaunt?");
        System.out.println("If you have an accaunt press '1'");
        System.out.println("If you wish to register press '2'");
        System.out.println("If you wish to exit the programm press '3'");
        int answ = scanner.nextInt();
        System.out.print("LOGIN: ");
        String login = scanner.next();
        System.out.print("PASSWORD: ");
        String password = scanner.next();
        loggedInUser = userService.login(loginUsername, loginPassword);
        if (loggedInUser != null) {
            System.out.println("Welcome " + loggedInUser.getName());

        } else {
            System.out.println("No such user found");
        }
    }


    }


}
