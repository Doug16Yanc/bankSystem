package services;

import entities.persons.NaturalCustomer;

import static utils.Utility.println;
import static utils.Utility.sc;

public class NaturalCustomerService {
    public static void interactesNatural(NaturalCustomer naturalCustomer){
        println("Welcome, dearest " + naturalCustomer.getName() + ".\n");
        System.out.println("        Choose an option        \n" +
                "                   REQUESTS\n\n" +
                "                   1 - Creation of account\n" +
                "                   2 - Delete an account\n" +
                "                   3 - Disable an account\n\n" +
                "                   PERSONAL DATA\n\n" +
                "                   4 - Query data\n" +
                "                   5 - Update\n\n");
        int option = sc.nextInt();

        switch(option){
            case 1 -> {

            }
            case 2 -> {

            }
            case 3 -> {

            }
            case 4 -> {

            }
            case 5 -> {

            }
            default -> {
                println("Sorry, however this option´s no existent.\n");
            }
        }
    }
}
