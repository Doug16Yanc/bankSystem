package services;

import entities.bank.Request;
import entities.persons.Clerk;
import enumerations.TypeRequest;

import java.util.ArrayList;
import java.util.List;

import static application.Program.doFirstInteraction;
import static services.ClerkServiceRequests.*;
import static utils.Utility.println;
import static utils.Utility.sc;

public class ClerkService {
    public static boolean doLoginClerk(List<Request> requestList){
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
                interactesClerk(helpClerk, requestList);
                break;
            }
            else{
                println("Username or password not recognized.\n");
            }
        } while(attempts > 0);
        return validClerk;
    }
    public static void interactesClerk(Clerk clerk, List<Request> requestList){
        println("Welcome to your page, dearest " + clerk.getName() + ".\n");
        do {
            System.out.println("            Choose an option            \n\n" +
                    "                       CUSTOMER REQUESTS\n\n" +
                    "                       1 - Create account of customers\n" +
                    "                       2 - Delete account of customers\n" +
                    "                       3 - Disable account of customers\n" +
                    "                       4 - Working with income change requests\n\n" +
                    "                       PERSONAL DATA\n\n" +
                    "                       5 - Query data\n" +
                    "                       6 - Update data\n\n" +
                    "                       SYSTEM OPERATIONS\n\n" +
                    "                       7 - Return to the initial menu\n");
            int option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    createAccountCustomer(requestList);
                }
                case 2 -> {
                    disableAccountCustomer(requestList);
                }
                case 3 -> {
                    deleteAccountCustomer(requestList);
                }
                case 4 -> {
                    List<String> updateRequest = null;
                    analyzeIncomeUpdate(updateRequest);
                }
                case 5 -> {
                    queryDataClerk(clerk);
                }
                case 6 -> {
                    updateDataClerk(clerk);
                }
                case 7 -> {
                    doFirstInteraction();
                    break;
                }
                default -> {
                    println("Sorry, however this option´s no existent.\n");
                }
            }
        } while(true);
    }

    public static String listRequests(List<Request> requestList){
        for (Request request : requestList){
            return String.format("\nCode identifier : " + request.getIdRequest() +
                    "\nId customer : " + request.getCustomer().getId() +
                    "\nName customer : " + request.getCustomer().getName() +
                    "\nEmail customer : " + request.getCustomer().getEmail() +
                    "\nType request : " + request.getTypeRequest() +
                    "\nType customer : " + request.getTypeRequest());
        }
        return "";
    }
    public static int createAccountCustomer(List<Request> requestList){
        println("List requests\n");
        boolean requestFound = false;
        for (Request request : requestList){
            if (request.getTypeRequest() == TypeRequest.CREATION){
                System.out.println(listRequests(requestList));
                requestFound = true;
                break;
            }
        }
        if (requestFound){
            Request accountCreation = null;
            for (Request request : requestList){
                if(request.getTypeRequest() == TypeRequest.CREATION){
                    accountCreation = request;
                    break;
                }
            }
            if (accountCreation != null){
                doCreationAccount(accountCreation);
            }
        }
        else {
            println("No creation account requests.\n");
        }
        return 1;
    }
    public static int deleteAccountCustomer(List<Request> requestList){
        println("List request\n");
        boolean requestFound = false;
        for (Request request : requestList){
            if (request.getTypeRequest() == TypeRequest.DELETION){
                System.out.println(listRequests(requestList));
                requestFound = true;
                break;
            }
        }
        if (requestFound) {
            Request accountDeletion = null;
            for (Request request : requestList){
                if (request.getTypeRequest() == TypeRequest.DELETION){
                    accountDeletion = request;
                    break;
                }
            }
            if (accountDeletion != null){
                doDeletionAccount(accountDeletion);
            }
        }
        else {
            println("No deletion account requests.\n");
        }
        return 1;
    }
    public static int disableAccountCustomer(List<Request> requestList){
        println("List request\n");
        boolean requestFound = false;
        for (Request request : requestList){
            if (request.getTypeRequest() == TypeRequest.DISABILITATION){
                System.out.println(listRequests(requestList));
                requestFound = true;
                break;
            }
        }
        if (requestFound){
            Request accountDisabilitation = null;
            for (Request request : requestList){
                if (request.getTypeRequest() == TypeRequest.DISABILITATION){
                    accountDisabilitation = request;
                    break;
                }
            }
            if (accountDisabilitation != null){
                doDisabilitationAccount(accountDisabilitation);
            }
        }
        else {
            println("No disabilitation account requests.\n");
        }
        return 1;
    }
    public static boolean analyzeIncomeUpdate(List<String> updateRequest){
        return true;
    }
    public static void queryDataClerk(Clerk clerk){
        println("           Data clerk      \n\n" +
                "Id : " + clerk.getId() +
                "\nName : " + clerk.getName() +
                "\nEmail : " + clerk.getEmail() +
                "\nUsername on system : " + clerk.getEmail());
    }
    public static void updateDataClerk(Clerk clerk){
        println("       PAGE UPDATE DATA\n\n");
        System.out.println("You can´t update your identifier code (Id) and your name.\n");
        System.out.println("Select an option:\n" +
                "1 - Email " +
                "2 - Username " +
                "3 - Password ");
        int option = sc.nextInt();
        sc.nextLine();
        switch (option){
            case 1 -> {
                System.out.println("New email: ");
                String newEmail = sc.nextLine();

                clerk.setEmail(newEmail);
            }
            case 2 -> {
                System.out.println("New username : ");
                String newUsername = sc.nextLine();

                clerk.setUsername(newUsername);
            }
            case 3 -> {
                System.out.println("Confirm your current password:");
                String password = sc.nextLine();

                if (password.equals(clerk.getPassword())){
                    System.out.println("New password: ");
                    String newPassword = sc.nextLine();

                    clerk.setPassword(newPassword);
                }
                else {
                    println("Password not recognized for clerk " + clerk.getName() + " and " + clerk.getEmail());
                }
            }
            default -> {
                println("Sorry, however this option´s no existent.\n");
            }
        }
    }
}
