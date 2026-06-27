package com.evolution.javafeatures.designpatterns.types.command;

//This will act as a implementation for Receiver "Transaction"

public class UpiTransaction implements Transaction{

    @Override
    public String executeTransaction() {
        return "UPI transaction executed!!";
    }

    @Override
    public String rollbackTransaction() {
        return "UPI transaction rolled-back!!";
    }
}
