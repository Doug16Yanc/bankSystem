package entities.bank;

import enumerations.AccountSituation;

import java.util.Date;
import java.util.List;

public class CheckingAccount extends Account{
    private Double limitAccount;

    public CheckingAccount(Long numberAccount, Date apertureAccount, Date closureAccount, AccountSituation accountSituation, String password, Double balance, List<Movement> movementList, Double limitAccount) {
        super(numberAccount, apertureAccount, closureAccount, accountSituation, password, balance, movementList);
        this.limitAccount = limitAccount;
    }
    public Double getLimitAccount() {
        return limitAccount;
    }
    public void setLimitAccount(Double limitAccount) {
        this.limitAccount = limitAccount;
    }
}
