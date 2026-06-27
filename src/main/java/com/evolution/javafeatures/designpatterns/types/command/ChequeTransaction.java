package com.evolution.javafeatures.designpatterns.types.command;

//This will act as a implementation for Receiver "Transaction"
public class ChequeTransaction implements Transaction{
    @Override
    public String executeTransaction() {
        return "Cheque transaction executed!!";
    }

    @Override
    public String rollbackTransaction() {
        return "Cheque transaction rolled-back!!";
    }
}
