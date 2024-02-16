package services;

import entities.bank.Request;
import entities.persons.NaturalCustomer;
import enumerations.TypeAccountCreation;
import enumerations.TypeCustomer;
import enumerations.TypeRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static utils.Utility.println;
import static utils.Utility.sc;

public class NaturalCustomerService {
    public static void interactesNatural(NaturalCustomer naturalCustomer, List<Request> requestList){
        println("Welcome, dearest " + naturalCustomer.getName() + ".\n");
        System.out.println("        Choose an option        \n" +
                "                   REQUESTS\n\n" +
                "                   1 - Creation of account\n" +
                "                   2 - Delete an account\n" +
                "                   3 - Disable an account\n\n" +
                "                   PERSONAL DATA\n\n" +
                "                   4 - Query data\n" +
                "                   5 - Update data\n\n");
        int option = sc.nextInt();

        switch(option){
            case 1 -> {
                sc.nextLine();
                System.out.println("What´s type account?\n C - Checking account\n S - Savings account\n");
                String choose = sc.nextLine();

                switch (choose.toLowerCase()){
                    case "c" -> {
                        Request request01 = new Request(UUID.randomUUID(), naturalCustomer, TypeRequest.CREATION, TypeCustomer.NATURAL, TypeAccountCreation.CHECKING);
                        requestList.add(request01);
                    }
                    case "s" -> {
                        Request request1 = new Request(UUID.randomUUID(), naturalCustomer, TypeRequest.CREATION, TypeCustomer.NATURAL, TypeAccountCreation.SAVINGS);
                        requestList.add(request1);
                    }
                    default -> {
                        println("Sorry, however this choose´s no existent.\n");
                    }
                }

            }
            case 2 -> {

                boolean accounts = requestList.stream().anyMatch(request -> request.getTypeRequest() ==
                        TypeRequest.CREATION && request.getTypeCustomer() == TypeCustomer.LEGAL);

                if (accounts){
                    Request request2 = new Request(UUID.randomUUID(), naturalCustomer,  TypeRequest.DELETION, TypeCustomer.NATURAL, null);
                    println("Accout disabilitation sent sucessfully. Identifier code of the request : " + request2.getIdRequest());
                    requestList.add(request2);
                }
                else {
                    println("Sorry, but you haven´t at least one account to request a disabilitation.\n");
                }
            }
            case 3 -> {

                boolean accounts = requestList.stream().anyMatch(request -> request.getTypeRequest() ==
                        TypeRequest.CREATION && request.getTypeCustomer() == TypeCustomer.NATURAL);

                if (accounts){
                    Request request3 = new Request(UUID.randomUUID(), naturalCustomer, TypeRequest.DISABILITATION, TypeCustomer.NATURAL, null);
                    println("Account deletion request sent sucessfully. Identifier code of the request : " + request3.getIdRequest());
                    requestList.add(request3);
                }
                else {
                    println("Sorry, but you haven´t at least one account to request a deletion.\n");
                }

            }
            case 4 -> {
                queryDataNatural(naturalCustomer);
            }
            case 5 -> {
                updateDataNatural(naturalCustomer);
            }
            default -> {
                println("Sorry, however this option´s no existent.\n");
            }
        }
    }
    public static void queryDataNatural(NaturalCustomer naturalCustomer){
        println("           NATURAL CUSTOMER DATA\n\n" +
                "           Id : " + naturalCustomer.getId() +
                "\n         Name : " + naturalCustomer.getName() +
                "\n         Zip code : " + naturalCustomer.getZipCode() +
                "\n         Telephone : " + naturalCustomer.getTelephone() +
                "\n         Email : " + naturalCustomer.getEmail() +
                "\n         Income : " + naturalCustomer.getIncome() +
                "\n         Status : " + naturalCustomer.getCustomerSituation() +
                "\n         Birthday : " + naturalCustomer.getBirthday());
    }
    public static void updateDataNatural(NaturalCustomer naturalCustomer){
        List<String> updateRequestNatural = new ArrayList<>();
        println("           UPDATE CUSTOMER DATA        \n\n");
        System.out.println("you can't change your identifier code (Id), CPF, RG, name, status or birthday,\n" +
                " the income can only be changed by the bank clerk after an explanatory description\n made by the customer.\n");
        System.out.println("Choose the option you want change:\n" +
                "           1 - Zip code:   \n" +
                "           2 - Telephone   \n" +
                "           3 - Email   \n" +
                "           4 - Username \n" +
                "           5 - Password \n" +
                "           6 - Income \n");
        int option = sc.nextInt();

        switch (option){
            case 1 -> {
                System.out.println("New zip code : ");
                String newZipCode = sc.nextLine();

                naturalCustomer.setZipCode(newZipCode);
            }
            case 2 -> {
                System.out.println("New telephone : ");
                String newTelephone = sc.nextLine();

                naturalCustomer.setTelephone(newTelephone);
            }
            case 3 -> {
                System.out.println("New email : ");
                String newEmail = sc.nextLine();

                naturalCustomer.setEmail(newEmail);
            }
            case 4 -> {
                System.out.println("New username : ");
                String newUsername = sc.nextLine();

                naturalCustomer.setUsername(newUsername);
            }
            case 5 -> {
                System.out.println("New password : ");
                String newPassword = sc.nextLine();

                naturalCustomer.setPassword(newPassword);
            }
            case 6 -> {
                System.out.println("Give a small explanatory description about your request:\n");
                String description = sc.nextLine();

                System.out.println("Which value do you want to change to?");
                Double newIncome = sc.nextDouble();

                updateRequestNatural.add("Request by " + naturalCustomer.getId() + "," + naturalCustomer.getName() + "," + naturalCustomer.getCpf() +
                        description + newIncome);
                ClerkService.analyzeIncomeUpdate(updateRequestNatural);
            }
            default -> {
                println("Sorry, however this option´s no existent.\n");
            }
        }
    }
}
