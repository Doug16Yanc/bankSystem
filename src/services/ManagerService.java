package services;

import entities.persons.Manager;

import static application.Program.doFirstInteraction;
import static utils.Utility.println;
import static utils.Utility.sc;

public class ManagerService {
    public static boolean doLoginManager(){
        Manager manager = new Manager(1L, "Doug", "doug", "16");

        println("Enter with your username and password.\n");
        System.out.println("Username:");
        String username = sc.nextLine();
        System.out.println("Password:");
        String password = sc.nextLine();

        if (username.equals(manager.getUsername()) && password.equals(manager.getPassword())){
            interactesManager(manager);
            return true;
        }
        println("Username or password not recognized.\n");
        return false;
    }
    public static void interactesManager(Manager manager){
        println("Welcome to your page, dearest " + manager.getName() + ".\n");
        do {
            System.out.println("Choose an option:\n");
            System.out.println("        PEOPLE DEMANDS      \n\n" +
                    "                   1 - Change limit checking account by demand.\n" +
                    "                   2 - Change yield savings account by demand.\n\n" +
                    "                   BANK APPOINTMENTS       \n\n" +
                    "                   3 - See reports \n" +
                    "                   4 - Return to the initial menu\n");
            int option = sc.nextInt();

            switch (option) {
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {
                    doFirstInteraction();
                    break;
                }
                default -> {
                    println("Sorry, however this option´s no existent.\n");
                }
            }
        } while(true);
    }
}
