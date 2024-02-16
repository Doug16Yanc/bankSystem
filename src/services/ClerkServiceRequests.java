package services;

import entities.bank.Request;

import static utils.Utility.println;

public class ClerkServiceRequests {

    public static void doCreationAccount(Request accountCreation){
        println("Performing account creation, identifier code : " + accountCreation.getIdRequest());


    }
    public static void doDeletionAccount(Request accountDeletion){
        println("Performing account deletion, identifier code : " + accountDeletion.getIdRequest());
    }
    public static void doDisabilitationAccount(Request accountDisabilitation){
        println("Perfoming account disabilitation, identifier code : " + accountDisabilitation.getIdRequest());
    }
}
