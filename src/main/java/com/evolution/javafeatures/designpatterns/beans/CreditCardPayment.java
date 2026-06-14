package com.evolution.javafeatures.designpatterns.beans;

public class CreditCardPayment implements Payment{
    @Override
    public String pay() {
        return "Credit Card Payment Complete!!";
    }
}
