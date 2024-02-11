package entities.bank;

import enumerations.AccountSituation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private Long numberAccount;
    private Date apertureAccount;
    private Date closureAccount;
    private AccountSituation accountSituation;
    private String password;
    private Double balance;

    private List<Movement> movementList = new ArrayList<>();

    public Account(Long numberAccount, Date apertureAccount, Date closureAccount, AccountSituation accountSituation, String password, Double balance, List<Movement>movementList){
        this.numberAccount = numberAccount;
        this.apertureAccount = apertureAccount;
        this.closureAccount = closureAccount;
        this.accountSituation = accountSituation;
        this.password = password;
        this.balance = balance;
        this.movementList = movementList;
    }

    public Long getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(Long numberAccount) {
        this.numberAccount = numberAccount;
    }

    public Date getApertureAccount() {
        return apertureAccount;
    }

    public void setApertureAccount(Date apertureAccount) {
        this.apertureAccount = apertureAccount;
    }

    public Date getClosureAccount() {
        return closureAccount;
    }

    public void setClosureAccount(Date closureAccount) {
        this.closureAccount = closureAccount;
    }

    public AccountSituation getAccountSituation() {
        return accountSituation;
    }

    public void setAccountSituation(AccountSituation accountSituation) {
        this.accountSituation = accountSituation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Movement> getMovementList() {
        return movementList;
    }

    public void setMovementList(List<Movement> movementList) {
        this.movementList = movementList;
    }
}
