package com.evolution.javafeatures.designpatterns.beans;

public class RazorPayment implements Payment{
    @Override
    public String pay() {
        return "RazorPay Payment Complete!!";
    }
}
