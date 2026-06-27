package com.evolution.javafeatures.designpatterns.types.factory;

public class RazorPayment implements Payment {
    @Override
    public String pay() {
        return "RazorPay Payment Complete!!";
    }
}
