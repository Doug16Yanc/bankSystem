package entities.bank;

import entities.persons.Customer;
import enumerations.TypeAccountCreation;
import enumerations.TypeCustomer;
import enumerations.TypeRequest;

import java.util.UUID;

public class Request {
    private UUID idRequest;

    private Customer customer;
    private TypeRequest typeRequest;

    private TypeCustomer typeCustomer;

    private TypeAccountCreation typeAccountCreation;

    public Request(UUID idRequest, Customer customer, TypeRequest typeRequest, TypeCustomer typeCustomer, TypeAccountCreation typeAccountCreation){
        this.idRequest = idRequest;
        this.customer = customer;
        this.typeRequest = typeRequest;
        this.typeCustomer = typeCustomer;
        this.typeAccountCreation = typeAccountCreation;
    }

    public UUID getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(UUID idRequest) {
        this.idRequest = idRequest;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TypeRequest getTypeRequest() {
        return typeRequest;
    }

    public void setTypeRequest(TypeRequest typeRequest) {
        this.typeRequest = typeRequest;
    }

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public TypeAccountCreation getTypeAccountCreation() {
        return typeAccountCreation;
    }

    public void setTypeAccountCreation(TypeAccountCreation typeAccountCreation) {
        this.typeAccountCreation = typeAccountCreation;
    }
}
