package services;

import static utils.Utility.println;
import static utils.Utility.sc;

public class FinancialServices {
    public static int doFinancialOperations(){
        println("Financial operations\n");
        System.out.println("Choose an option\n" +
                "           1 - Deposit money\n" +
                "           2 - Withdraw money\n" +
                "           3 - Request statement\n" +
                "           4 - Perform transfer\n");
        int option = sc.nextInt();

        switch(option){
            case 1 -> {
                FinancialServices.doDepositMoney();
            }
            case 2 -> {
                FinancialServices.doWithdrawMoney();
            }
            case 3 -> {
                FinancialServices.returnBankStatement();
            }
            case 4 -> {
                FinancialServices.doBankTransfer();
            }
            default -> {
                println("Sorry, however this option´s no existent.\n");
            }
        }
        return 1;
    }
    public static boolean doDepositMoney() {
        return true;
    }
    public static boolean doWithdrawMoney(){
        return true;
    }
    public static String returnBankStatement(){
        return String.format("");
    }
    public static boolean doBankTransfer(){
        return true;
    }
}
