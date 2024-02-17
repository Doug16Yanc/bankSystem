package services;

import entities.bank.Request;
import entities.persons.LegalCustomer;
import enumerations.TypeAccountCreation;
import enumerations.TypeCustomer;
import enumerations.TypeRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static application.Program.doFirstInteraction;
import static services.FinancialServices.doFinancialOperations;
import static utils.Utility.println;
import static utils.Utility.sc;

public class LegalCustomerService {
    public static void interactesLegal(LegalCustomer legalCustomer, List<Request> requestList){
        println("Welcome, dearest " + legalCustomer.getName() + ".\n");
        do {
            System.out.println("        Choose an option        \n" +
                    "                   REQUESTS\n\n" +
                    "                   1 - Creation of account\n" +
                    "                   2 - Delete an account\n" +
                    "                   3 - Disable an account\n\n" +
                    "                   PERSONAL DATA\n\n" +
                    "                   4 - Query data\n" +
                    "                   5 - Update\n\n" +
                    "                   SYSTEM OPERATIONS\n\n" +
                    "                   6 - Go to the financial operations\n" +
                    "                   7 - Return to the initial menu\n");
            int option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("What´s type account?\n C/c - Checking\n S/s - Savings\n");
                    String choose = sc.nextLine();

                    switch (choose.toLowerCase()) {
                        case "c" -> {
                            Request request01 = new Request(UUID.randomUUID(), legalCustomer, TypeRequest.CREATION, TypeCustomer.LEGAL, TypeAccountCreation.CHECKING);
                            println("Account creation request sent successfully. Identifier code of the request : " + request01.getIdRequest());
                            requestList.add(request01);
                        }
                        case "s" -> {
                            Request request1 = new Request(UUID.randomUUID(), legalCustomer, TypeRequest.CREATION, TypeCustomer.LEGAL, TypeAccountCreation.SAVINGS);
                            println("Account creation request sent successfully. Identifier code of the request : " + request1.getIdRequest());
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

                    if (accounts) {
                        Request request2 = new Request(UUID.randomUUID(), legalCustomer, TypeRequest.DISABILITATION, TypeCustomer.LEGAL, null);
                        println("Account disabilition request sent successfully. Identifier code of the request : " + request2.getIdRequest());
                        requestList.add(request2);
                    } else {
                        println("Sorry, but you haven´t at least one account to request a disabilitation.\n");
                    }
                }
                case 3 -> {
                    boolean accounts = requestList.stream().anyMatch(request -> request.getTypeRequest() ==
                            TypeRequest.CREATION && request.getTypeCustomer() == TypeCustomer.LEGAL);

                    if (accounts) {
                        Request request3 = new Request(UUID.randomUUID(), legalCustomer, TypeRequest.DELETION, TypeCustomer.LEGAL, null);
                        println("Account deletion request sent sucessfully. Identifier code of the request : " + request3.getIdRequest());
                        requestList.add(request3);
                    } else {
                        println("Sorry, but you haven´t at least one account to request a deletion.\n");
                    }

                }
                case 4 -> {
                    queryDataLegal(legalCustomer);
                }
                case 5 -> {
                    updateDataLegal(legalCustomer);
                }
                case 6 -> {
                    doFinancialOperations();
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
    public static void queryDataLegal(LegalCustomer legalCustomer){
        println("           NATURAL CUSTOMER DATA\n\n" +
                "           Id : " + legalCustomer.getId() +
                "\n         CNPJ : " + legalCustomer.getCnpj() +
                "\n         Name : " + legalCustomer.getName() +
                "\n         Zip code : " + legalCustomer.getZipCode() +
                "\n         Telephone : " + legalCustomer.getTelephone() +
                "\n         Email : " + legalCustomer.getEmail() +
                "\n         Income : " + legalCustomer.getIncome() +
                "\n         Status : " + legalCustomer.getCustomerSituation());
    }
    public static void updateDataLegal(LegalCustomer legalCustomer){
        List<String> updateRequestLegal = new ArrayList<>();
        println("           UPDATE CUSTOMER DATA        \n\n");
        System.out.println("you can't change your identifier code (Id), CNPJ, name and status,\n" +
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

                legalCustomer.setZipCode(newZipCode);
            }
            case 2 -> {
                System.out.println("New telephone : ");
                String newTelephone = sc.nextLine();

                legalCustomer.setTelephone(newTelephone);
            }
            case 3 -> {
                System.out.println("New email : ");
                String newEmail = sc.nextLine();

                legalCustomer.setEmail(newEmail);
            }
            case 4 -> {
                System.out.println("New username : ");
                String newUsername = sc.nextLine();

                legalCustomer.setUsername(newUsername);
            }
            case 5 -> {
                System.out.println("New password : ");
                String newPassword = sc.nextLine();

                legalCustomer.setPassword(newPassword);
            }
            case 6 -> {
                System.out.println("Give a small explanatory description about your request:\n");
                String description = sc.nextLine();

                System.out.println("Which value do you want to change to?");
                Double newIncome = sc.nextDouble();

                updateRequestLegal.add("Request by " + legalCustomer.getId() + "," + legalCustomer.getName() + "," + legalCustomer.getCnpj() +
                        description + newIncome);
                ClerkService.analyzeIncomeUpdate(updateRequestLegal);
            }
            default -> {
                println("Sorry, however this option´s no existent.\n");
            }
        }
    }
}
