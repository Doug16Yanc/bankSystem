package services;

import entities.bank.Request;
import entities.persons.NaturalCustomer;
import enumerations.TypeCustomer;
import enumerations.TypeRequest;

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
                Request request1 = new Request(UUID.randomUUID(), TypeRequest.CREATION, TypeCustomer.NATURAL);
                requestList.add(request1);
            }
            case 2 -> {

                boolean accounts = requestList.stream().anyMatch(request -> request.getTypeRequest() ==
                        TypeRequest.CREATION && request.getTypeCustomer() == TypeCustomer.LEGAL);

                if (accounts){
                    Request request2 = new Request(UUID.randomUUID(), TypeRequest.DELETION, TypeCustomer.NATURAL);
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
                    Request request3 = new Request(UUID.randomUUID(), TypeRequest.DISABILITATION, TypeCustomer.NATURAL);
                    println("Account deletion request sent sucessfully. Identifier code of the request : " + request3.getIdRequest());
                    requestList.add(request3);
                }
                else {
                    println("Sorry, but you haven´t at least one account to request a deletion.\n");
                }

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
