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
        Map<Long, NaturalCustomer> naturalCustomerMap = new HashMap<>();
        Map<Long, LegalCustomer> legalCustomerMap = new HashMap<>();
        System.out.println("Hi, have you already registered in our system?\n Y/y - Yes\n N/n - Not\n");
        String option = sc.nextLine();

        switch(option.toLowerCase()){
            case "y" -> {
                doLoginCustomer(naturalCustomerMap, legalCustomerMap, requestList);
            }
            case "n" -> {
                doRecordCustomer(naturalCustomerMap, legalCustomerMap);
            }
            default -> {
                println("Sorry however this option´s no existent.\n");
            }
        }
        return true;
    }
    public static void doRecordCustomer(Map naturalCustomerMap, Map legalCustomerMap){

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

                Long idLegal = (long) GenerationId.generateId(legalCustomerMap);

                LegalCustomer legalCustomer = new LegalCustomer(idLegal, name, zipcode, telephone, email, income, username, password, CustomerSituation.ACTIVE, cnpj);

                System.out.println(proofRecordLegal(legalCustomer));

                legalCustomerMap.computeIfAbsent(legalCustomer.getId(), k -> new ArrayList<>().add(legalCustomer));

            }
            case "n" -> {
                System.out.println("CPF: ");
                String cpf = sc.nextLine();
                System.out.println("RG: ");
                String rg = sc.nextLine();
                System.out.println("Birthday: ");
                String birthday = sc.nextLine();

                Long idNatural = (long) GenerationId.generateId(naturalCustomerMap);


                NaturalCustomer naturalCustomer = new NaturalCustomer(idNatural, name, zipcode, telephone, email, income, username, password, CustomerSituation.ACTIVE, cpf, rg, birthday);

                System.out.println(proofRecordNatural(naturalCustomer));

                naturalCustomerMap.computeIfAbsent(naturalCustomer.getId(), k -> new ArrayList<>().add(naturalCustomer));

            }
            default -> {
                println("Sorry, however this option´s no existent.\n");
            }
        }
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
    public static boolean searchCustomer(Map <Long, NaturalCustomer> naturalCustomerMap, Map <Long, LegalCustomer> legalCustomerMap){
        println("Searching the customer...\n:");
        System.out.println("Enter your id:");
        Long id = sc.nextLong();

        if (naturalCustomerMap.containsKey(id) || legalCustomerMap.containsKey(id)){
            println("Customer found sucessfully!\n");
            return true;
        }
        println("Customer not found.\n");

        return false;
    }
    public static boolean doLoginCustomer(Map <Long, NaturalCustomer>naturalCustomerMap, Map <Long, LegalCustomer> legalCustomerMap, List<Request> requestList){
        println("       PAGE LOGIN CUSTOMER     \n");
        int attempts = 3;
        boolean validNatural = false;
        boolean validLegal = false;
        NaturalCustomer helpNatural = null;
        LegalCustomer helpLegal = null;
        if(searchCustomer(naturalCustomerMap, legalCustomerMap) == true) {
            System.out.println("Enter with your username and password. You have three chances.\n");

            do {
                System.out.println("Username:");
                String username = sc.nextLine();

                System.out.println("Password:");
                String password = sc.nextLine();

                System.out.println("L/l - Legal customer\n N/n - Natural customer\n ");
                String option = sc.nextLine();

                switch (option.toLowerCase()) {
                    case "l" -> {
                        for (LegalCustomer legalCustomer : legalCustomerMap.values()) {
                            if (legalCustomer.getUsername().equals(username) && legalCustomer.getPassword().equals(password)) {
                                validLegal = true;
                                helpLegal = legalCustomer;
                                break;
                            }
                        }
                        if (validLegal) {
                            LegalCustomerService.interactesLegal(helpLegal, requestList);
                            break;
                        } else {
                            println("Username or password not recognized.\n");
                        }
                    }
                    case "n" -> {
                        for (NaturalCustomer naturalCustomer : naturalCustomerMap.values()) {
                            if (naturalCustomer.getUsername().equals(username) && naturalCustomer.getPassword().equals(password)) {
                                validNatural = true;
                                helpNatural = naturalCustomer;
                                break;
                            }
                        }
                        if (validNatural) {
                            NaturalCustomerService.interactesNatural(helpNatural, requestList);
                            break;
                        } else {
                            println("Username or password not recognized.\n");
                        }
                    }
                    default -> {
                        println("Sorry, however this option´s no existent.\n");
                    }
                }
            } while (attempts > 0);
        }
        else{
            doFirstInteraction();
        }
        return true;
    }
}
