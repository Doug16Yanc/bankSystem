package entities.persons;

import enumerations.CustomerSituation;

public abstract class Customer {
    private int id;
    private String name;
    private String zipCode;
    private String telephone;
    private String email;
    private Double income;

    public String username;

    public String password;

    private CustomerSituation customerSituation;

    public Customer(int id, String name, String zipCode, String telephone, String email, Double income, String username, String password, CustomerSituation customerSituation){
        this.id = id;
        this.name = name;
        this.zipCode = zipCode;
        this.telephone = telephone;
        this.email = email;
        this.income = income;
        this.username = username;
        this.password = password;
        this.customerSituation = customerSituation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getIncome() {
        return income;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setIncome(Double income) {
        this.income = income;
    }

    public CustomerSituation getCustomerSituation() {
        return customerSituation;
    }

    public void setCustomerSituation(CustomerSituation customerSituation) {
        this.customerSituation = customerSituation;
    }
}
