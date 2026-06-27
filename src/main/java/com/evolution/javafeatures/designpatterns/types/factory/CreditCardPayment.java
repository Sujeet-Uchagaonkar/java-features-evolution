package com.evolution.javafeatures.designpatterns.types.factory;


public class CreditCardPayment implements Payment {
    @Override
    public String pay() {
        return "Credit Card Payment Complete!!";
    }
}
