package services;

import entities.bank.Request;
import entities.persons.LegalCustomer;
import entities.persons.NaturalCustomer;
import enumerations.CustomerSituation;
import repositories.GenerationId;

import java.util.*;

import static application.Program.doFirstInteraction;
import static utils.Utility.*;

public class CustomerService {
    public static boolean asksAboutRegister(List<Request> requestList){
        List<NaturalCustomer> naturalCustomerList = new ArrayList<>();
        List<LegalCustomer> legalCustomerList = new ArrayList<>();
        System.out.println("Hi, have you already registered in our system?\n Y/y - Yes\n N/n - Not\n");
        String option = sc.nextLine();

        switch(option.toLowerCase()){
            case "y" -> {
                System.out.println("L/l - Legal customer\nN/n - Natural customer\n");
                String choose = sc.nextLine();

                switch(choose){
                    case "l" -> {
                        doLoginLegalCustomer(legalCustomerList, requestList);
                    }
                    case "n" -> {
                        doLoginNaturalCustomer(naturalCustomerList, requestList);
                    }
                    default -> {
                        println("Sorry, however this option´s no existent.\n");
                    }
                }
            }
            case "n" -> {
                doRecordCustomer(naturalCustomerList, legalCustomerList);
            }
            default -> {
                println("Sorry however this option´s no existent.\n");
            }
        }
        return true;
    }
    public static void doRecordCustomer(List<NaturalCustomer> naturalCustomerList, List<LegalCustomer> legalCustomerList){

        println("       PAGE RECORD CUSTOMER            \n");

        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Zip code: ");
        String zipcode = sc.nextLine();
        System.out.println("Telephone: ");
        String telephone = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Income :");
        Double income = sc.nextDouble();
        sc.nextLine();
        System.out.println("Username: ");
        String username = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();

        System.out.println("Person type?\n L/l - Legal person\n N/n - Natural person\n");
        String option = sc.nextLine();

        switch (option){
            case "l" -> {
                System.out.println("CNPJ: ");
                Long cnpj = sc.nextLong();

                int idLegal = GenerationId.generateId(legalCustomerList);

                LegalCustomer legalCustomer = new LegalCustomer(idLegal, name, zipcode, telephone, email, income, username, password, CustomerSituation.ACTIVE, cnpj);

                legalCustomerList.add(legalCustomer);

                System.out.println(proofRecordLegal(legalCustomer));

            }
            case "n" -> {
                System.out.println("CPF: ");
                String cpf = sc.nextLine();
                System.out.println("RG: ");
                String rg = sc.nextLine();
                System.out.println("Birthday: ");
                String birthday = sc.next();

                int idNatural = GenerationId.generateId(naturalCustomerList);

                NaturalCustomer naturalCustomer = new NaturalCustomer(idNatural, name, zipcode, telephone, email, income, username, password, CustomerSituation.ACTIVE, cpf, rg, birthday);

                naturalCustomerList.add(naturalCustomer);

                System.out.println(proofRecordNatural(naturalCustomer));

            }
            default -> {
                println("Sorry, however this option´s no existent.\n");
            }
        }
        doFirstInteraction();
    }
    public static String proofRecordLegal(LegalCustomer legalCustomer){
        Date currentDate = new Date();
        return String.format("      PROOF RECORD LEGAL CUSTOMER IN SYSTEM\n\n" +
                "                   PERSONAL DATA\n\n" +
                "\n                 Id : " + legalCustomer.getId() +
                "\n                 CNPJ : " + legalCustomer.getCnpj() +
                "\n                 Name : " + legalCustomer.getName() +
                "\n                 Telephone : " + legalCustomer.getTelephone() +
                "\n                 Email : " + legalCustomer.getEmail() +
                "\n                 Income : " + legalCustomer.getIncome() +
                "\n\n               OPERATION DATA\n\n" +
                "\n                 Data and hour : " + currentDate +
                "\n                 Number code : " + UUID.randomUUID());

    }
    public static String proofRecordNatural(NaturalCustomer naturalCustomer){
        Date currentDate = new Date();
        return String.format("      PROOF RECORD LEGAL CUSTOMER IN SYSTEM\n\n" +
                "                   PERSONAL DATA\n\n" +
                "\n                 Id : " + naturalCustomer.getId() +
                "\n                 CPF : " + naturalCustomer.getCpf() +
                "\n                 Name : " + naturalCustomer.getName() +
                "\n                 Telephone : " + naturalCustomer.getTelephone() +
                "\n                 Email : " + naturalCustomer.getEmail() +
                "\n                 Income : " + naturalCustomer.getIncome() +
                "\n\n               OPERATION DATA\n\n" +
                "\n                 Data and hour : " + currentDate +
                "\n                 Number code : " + UUID.randomUUID());
    }

    public static void doLoginLegalCustomer(List<LegalCustomer> legalCustomerList, List<Request> requestList) {
        println("       PAGE LOGIN CUSTOMER     \n");
        int attempts = 3;
        boolean validLegal = false;
        println("Searching the customer...\n:");
        System.out.println("Enter your id:");
        int id = sc.nextInt();

        for (LegalCustomer legalCustomer : legalCustomerList) {

            if (legalCustomer.getId() == id) {
                println("Customer found successfully!\n");
                validLegal = true;
                sc.nextLine();
                do {
                    System.out.println("Enter with your username and password. You have three chances.\n");

                    System.out.println("Username:");
                    String username = sc.nextLine();

                    System.out.println("Password:");
                    String password = sc.nextLine();

                    if (legalCustomer.getUsername().equals(username) && legalCustomer.getPassword().equals(password)) {
                        LegalCustomerService.interactesLegal(legalCustomer, requestList);
                        break;
                    }
                    else {
                        println("Username or password not recognized.\n");
                        attempts--;
                    }
                } while (attempts > 0);
            }
            if (!validLegal) {
                println("Customer not found.\n");
            }
        }
    }

    public static void doLoginNaturalCustomer(List<NaturalCustomer> naturalCustomerList, List<Request>requestList) {
        int attempts = 3;
        boolean validNatural = false;
        NaturalCustomer helpNatural = null;
        println("Searching the customer...\n:");
        System.out.println("Enter your id:");
        int id = sc.nextInt();

        for (NaturalCustomer naturalCustomer : naturalCustomerList) {
            if (naturalCustomer.getId() == id) {
                println("Customer found successfully!\n");
                validNatural = true;
                do {
                    System.out.println("Enter with your username and password. You have three chances.\n");

                    System.out.println("Username:");
                    String username = sc.nextLine();

                    System.out.println("Password:");
                    String password = sc.nextLine();

                    if (naturalCustomer.getUsername().equals(username) && naturalCustomer.getPassword().equals(password)) {
                        NaturalCustomerService.interactesNatural(naturalCustomer, requestList);
                    } else {
                        println("Username or password not recognized.\n");
                        attempts--;
                    }
                } while (attempts > 0);
            }
            if (!validNatural){
                println("Customer not found.\n");
            }
        }
    }
}
