package com.evolution.javafeatures.designpatterns.types.command;

public class RollbackTransaction implements TransactionCommand{
    Transaction transaction;

    RollbackTransaction(Transaction transaction){
        this.transaction = transaction;
    }

    @Override
    public String executeTransaction() {
       return this.transaction.rollbackTransaction();
    }
}
