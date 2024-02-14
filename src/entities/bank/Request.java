package entities.bank;

import enumerations.TypeCustomer;
import enumerations.TypeRequest;

import java.util.UUID;

public class Request {
    private UUID idRequest;
    private TypeRequest typeRequest;

    private TypeCustomer typeCustomer;

    public Request(UUID idRequest, TypeRequest typeRequest, TypeCustomer typeCustomer){
        this.idRequest = idRequest;
        this.typeRequest = typeRequest;
        this.typeCustomer = typeCustomer;
    }

    public UUID getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(UUID idRequest) {
        this.idRequest = idRequest;
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
}
