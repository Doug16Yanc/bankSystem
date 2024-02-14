package services;

import entities.persons.Clerk;

import java.util.ArrayList;
import java.util.List;

import static utils.Utility.println;
import static utils.Utility.sc;

public class ClerkService {
    public static boolean doLoginClerk(){
        List<Clerk> clerkList = new ArrayList<>();
        Clerk helpClerk = null;
        Clerk c1 = new Clerk(2L, "Clara", "clara@gmail.com", "clara", "29");
        Clerk c2 = new Clerk(3L, "Marco", "marco@hotmail.com", "marco", "25");
        Clerk c3 = new Clerk(4L, "Clyment", "clyment@outlook.com", "cly", "23");

        clerkList.addAll(List.of(c1, c2, c3));

        int attempts = 3;
        boolean validClerk = false;
        println("Login page clerks.\n");

        System.out.println("Enter with your username and password. You have three chances.\n");

        do{
            System.out.println("Username:");
            String username = sc.nextLine();

            System.out.println("Password:");
            String password = sc.nextLine();

            for (Clerk clerk : clerkList){
                if (username.equals(clerk.getUsername()) && password.equals(clerk.getPassword())) {
                    validClerk = true;
                    helpClerk = clerk;
                    break;
                }
            }
            if (validClerk){
                println("Login successfully.\n");
                interactesClerk(helpClerk);
                break;
            }
            else{
                println("Username or password not recognized.\n");
            }
        } while(attempts > 0);
        return validClerk;
    }
    public static void interactesClerk(Clerk clerk){
        println("Welcome to your page, dearest " + clerk.getName() + ".\n");
        System.out.println("            Choose an option            \n\n" +
                "                       1 - Create account of customers\n" +
                "                       2 - Delete account of customers\n" +
                "                       3 - Disable account of customers\n");
    }
}
