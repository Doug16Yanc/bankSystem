package services;

import entities.persons.Clerk;
import entities.persons.LegalCustomer;
import entities.persons.Manager;
import entities.persons.NaturalCustomer;
import enumerations.CustomerSituation;
import repositories.GenerationId;

import java.util.HashMap;
import java.util.Map;

import static utils.Utility.println;
import static utils.Utility.sc;

public class CustomerService {
    public static boolean asksAboutRegister(){
        Map<Long, NaturalCustomer> naturalCustomerMap = new HashMap<>();
        Map<Long, LegalCustomer> legalCustomerMap = new HashMap<>();
        System.out.println("Hi, have you already registered in our system?\n Y/y - Yes\n N/n - Not\n");
        String option = sc.nextLine();

        switch(option.toLowerCase()){
            case "y" -> {
                doLoginCustomer(naturalCustomerMap, legalCustomerMap);
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

                legalCustomerMap.put(idLegal, legalCustomer);
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

                naturalCustomerMap.put(idNatural, naturalCustomer);
            }
            default -> {
                println("Sorry, however this option´s no existent.\n");
            }
        }
    }
    public static boolean searchCustomer(){
        return true;
    }
    public static boolean doLoginCustomer(Map <Long, NaturalCustomer>naturalCustomerMap, Map <Long, LegalCustomer> legalCustomerMap){
        println("       PAGE LOGIN CUSTOMER     \n");
        int attempts = 3;
        boolean validNatural = false;
        boolean validLegal = false;
        NaturalCustomer helpNatural = null;
        LegalCustomer helpLegal = null;
        System.out.println("Enter with your username and password. You have three chances.\n");

        do{
            System.out.println("Username:");
            String username = sc.nextLine();

            System.out.println("Password:");
            String password = sc.nextLine();

            System.out.println("L/l - Legal customer\n N/n - Natural customer\n ");
            String option = sc.nextLine();

            switch(option.toLowerCase()) {
                case "l" -> {
                    for (LegalCustomer legalCustomer : legalCustomerMap.values()){
                        if (legalCustomer.getUsername().equals(username) && legalCustomer.getPassword().equals(password)){
                            validLegal = true;
                            helpLegal = legalCustomer;
                            break;
                        }
                    }
                    if(validLegal){
                        interactesLegal(helpLegal);
                        break;
                    }
                    else {
                        println("Username or password not recognized.\n");
                    }
                }
                case "n" -> {
                    for (NaturalCustomer naturalCustomer : naturalCustomerMap.values()) {
                        if (naturalCustomer.getUsername().equals(username) && naturalCustomer.getPassword().equals(password)) {
                            validNatural= true;
                            helpNatural = naturalCustomer;
                            break;
                        }
                    }
                    if (validNatural) {
                        interactesNatural(helpNatural);
                        break;
                    } else {
                        println("Username or password not recognized.\n");
                    }
                }
                default -> {
                    println("Sorry, however this option´s no existent.\n");
                }
            }
        } while(attempts > 0);
        return true;
    }

    public static void interactesNatural(NaturalCustomer naturalCustomer){
        println("Welcome, dearest " + naturalCustomer.getName() + ".\n");
    }
    public static void interactesLegal(LegalCustomer legalCustomer){
        println("Welcome, dearest " + legalCustomer.getName() + ".\n");
    }
}