package entities.persons;

import entities.persons.Customer;
import enumerations.CustomerSituation;

import java.time.LocalDate;

public class NaturalCustomer extends Customer {
    private String cpf;
    private String rg;
    private LocalDate birthday;

    public NaturalCustomer(Long id, String name, String zipCode, String telephone, String email, Double income, String username, String password, CustomerSituation customerSituation, String cpf, String rg, LocalDate birthday){
        super(id, name, zipCode, telephone, email, income, username, password, customerSituation);
        this.cpf = cpf;
        this.rg = rg;
        this.birthday = birthday;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
