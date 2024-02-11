package application;

import services.*;

import static utils.Utility.println;
import static utils.Utility.sc;

public class Program {
    public static void main(String[] args) {
        println("Welcome to bank system management.\n");
        doFirstInteraction();
    }
    public static void doFirstInteraction(){
        println("Who are you?");
        System.out.println("    M/m - Bank manager\n");
        System.out.println("    B/b - Bank clerk\n");
        System.out.println("    C/c - Customer\n");
        String option = sc.nextLine();

        switch(option.toLowerCase()){
            case "m" -> {
                ManagerService.doLoginManager();
            }
            case "b" -> {

            }
            case "c" -> {

            }
            default -> {
                println("Sorry, however this option´s no existent.\n");
            }
        }
    }
}