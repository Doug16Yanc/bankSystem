package entities.persons;

import enumerations.CustomerSituation;

public class LegalCustomer extends Customer {
    private Long cnpj;

    public LegalCustomer(Long id, String name, String zipCode, String telephone, String email, Double income, String username, String password, CustomerSituation customerSituation, Long cnpj){
        super(id, name, zipCode, telephone, email, income, username, password, customerSituation);
        this.cnpj = cnpj;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }
}
