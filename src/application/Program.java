package application;

import entities.bank.Request;
import services.*;

import java.util.ArrayList;
import java.util.List;

import static utils.Utility.println;
import static utils.Utility.sc;

public class Program {
    public static void main(String[] args) {
        println("Welcome to bank system management.\n");
        doFirstInteraction();
    }
    public static void doFirstInteraction(){
        List<Request> requestList = new ArrayList<>();

        sc.nextLine();

        println("Who are you?");
        System.out.println("    M/m - Bank manager\n");
        System.out.println("    B/b - Bank clerk\n");
        System.out.println("    C/c - Customer\n");
        System.out.println("    O/o - Log out\n");
        String option = sc.nextLine();

        switch (option.toLowerCase()) {
            case "m" -> {
                ManagerService.doLoginManager();
            }
            case "b" -> {
                ClerkService.doLoginClerk(requestList);
            }
            case "c" -> {
                CustomerService.asksAboutRegister(requestList);
            }
            case "o" -> {
                println("Losing you is such a pity, I will miss you, farewell!\n");
                System.exit(0);
            }
            default -> {
                println("Sorry, however this option´s no existent.\n");
            }
        }
    }
}