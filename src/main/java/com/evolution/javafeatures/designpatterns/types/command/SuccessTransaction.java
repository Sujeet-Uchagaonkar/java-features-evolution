package com.evolution.javafeatures.designpatterns.types.command;

public class SuccessTransaction implements TransactionCommand {
    Transaction transaction;

    SuccessTransaction(Transaction transaction){
        this.transaction = transaction;
    }


    @Override
    public String executeTransaction() {
        return this.transaction.executeTransaction();
    }
}
