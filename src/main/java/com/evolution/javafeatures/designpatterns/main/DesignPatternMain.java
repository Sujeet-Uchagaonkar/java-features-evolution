package com.evolution.javafeatures.designpatterns.main;

import com.evolution.javafeatures.designpatterns.beans.Payment;
import com.evolution.javafeatures.designpatterns.beans.PaymentFactory;
import com.evolution.javafeatures.designpatterns.beans.SingletonDemoBean;

public class DesignPatternMain {

    public static void main(String[] args) {

        /**
         * Creational Design Patterns
         */

        //Singleton : Refer SingletonDemoBean class for implementation
        //Ensures that a class has only one instance and provides a global access point to it. e.g. DB/Loggging config.
        //SingletonDemoBean singletonDemoBean = new SingletonDemoBean(); // This wont be allowed as it
        SingletonDemoBean singletonDemoBean = SingletonDemoBean.getInstance(); // This ensures same instance is used which is created in its bean.


        //Factory Design pattern
        // Defines an interface for creating objects but lets subclasses decide which object to instantiate. Achieve loose coupling by delegating object creation to a method, making the system more flexible and extensible.
        PaymentFactory paymentFactory = new PaymentFactory();
        Payment razorPayment = paymentFactory.initiatePayment("RazorPay"); // If we want Credit type, we can specify. Also, we can add new type in factory without impacting existing types.
        System.out.println("Response of payment is : "+ razorPayment.pay());


    }

}
