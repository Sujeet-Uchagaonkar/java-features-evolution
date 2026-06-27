package com.evolution.javafeatures.designpatterns.types.command;

//This will act as a Receiver
public interface Transaction {
    String executeTransaction();
    String rollbackTransaction();
}
