package com.evolution.javafeatures.designpatterns.types.factory;


public class PaymentFactory {

    public Payment initiatePayment(String paymentType) {

        switch (paymentType) {
            case "CreditCard":
                return new CreditCardPayment();
            case "RazorPay":
                return new RazorPayment();
            default:
                return null;
        }

    }
}
