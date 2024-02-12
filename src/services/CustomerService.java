package services;

import entities.persons.LegalCustomer;
import entities.persons.NaturalCustomer;
import enumerations.CustomerSituation;
import repositories.GenerationId;

import java.util.HashMap;
import java.util.Map;

import static utils.Utility.println;
import static utils.Utility.sc;

public class CustomerService {
    public static boolean asksAboutRegister(){
        System.out.println("Hi, have you already registered in our system?\n Y/y - Yes\n N/n - Not\n");
        String option = sc.nextLine();

        switch(option.toLowerCase()){
            case "y" -> {
                doLoginCustomer();
            }
            case "n" -> {
                doRecordCustomer();
            }
            default -> {
                println("Sorry however this option´s no existent.\n");
            }
        }
        return true;
    }
    public static void doRecordCustomer(){
        Map<Long, NaturalCustomer> naturalCustomerMap = new HashMap<>();
        Map<Long, LegalCustomer> legalCustomerMap = new HashMap<>();

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
    public static boolean doLoginCustomer(){
        return true;
    }
}
