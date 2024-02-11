package entities.bank;

import enumerations.AccountSituation;

import java.util.Date;
import java.util.List;

public class SavingsAccount extends Account{
    private Date birthdayAccount;
    private Double yield;

    public SavingsAccount(Long numberAccount, Date apertureAccount, Date closureAccount, AccountSituation accountSituation, String password, Double balance, List<Movement> movementList, Date birthdayAccount, Double yield){
        super(numberAccount, apertureAccount, closureAccount, accountSituation, password, balance, movementList);
        this.birthdayAccount = birthdayAccount;
        this.yield = yield;
    }

    public Date getBirthdayAccount() {
        return birthdayAccount;
    }

    public void setBirthdayAccount(Date birthdayAccount) {
        this.birthdayAccount = birthdayAccount;
    }

    public Double getYield() {
        return yield;
    }

    public void setYield(Double yield) {
        this.yield = yield;
    }
}
