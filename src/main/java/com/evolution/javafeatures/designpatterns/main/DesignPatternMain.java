package com.evolution.javafeatures.designpatterns.main;

import com.evolution.javafeatures.designpatterns.types.abstractfactory.*;
import com.evolution.javafeatures.designpatterns.types.mvccontroller.CartController;
import com.evolution.javafeatures.designpatterns.types.mvccontroller.CartModel;
import com.evolution.javafeatures.designpatterns.types.mvccontroller.CartView;
import com.evolution.javafeatures.designpatterns.types.factory.*;
import com.evolution.javafeatures.designpatterns.types.singleton.*;
import com.evolution.javafeatures.designpatterns.types.adapter.LegacySoapAdapter;
import com.evolution.javafeatures.designpatterns.types.factory.PaymentFactory;
import com.evolution.javafeatures.designpatterns.types.builder.Employee;

public class DesignPatternMain {

    public static void main(String[] args) {

        /**
         * There are 3 types of design patterns in Java : Creational,  Structural & Behavioral
         */


        /** Creational Design Patterns */

        //**** Singleton **** : Refer SingletonDemoBean class for implementation
        //Ensures that a class has only one instance and provides a global access point to it. e.g. DB/Loggging config.
        //SingletonDemoBean singletonDemoBean = new SingletonDemoBean(); // This wont be allowed as it restricts creating new object
        SingletonDemoBean singletonDemoBean = SingletonDemoBean.getInstance(); // This ensures same instance is used which is created in its bean.


        //**** Factory Design pattern ****
        // Defines an interface for creating objects but lets subclasses decide which object to instantiate. Achieve loose coupling by delegating object creation to a method, making the system more flexible and extensible.
        PaymentFactory paymentFactory = new PaymentFactory();
        Payment razorPayment = paymentFactory.initiatePayment("RazorPay"); // If we want Credit type, we can specify. Also, we can add new type in factory without impacting existing types.
        System.out.println("Response of payment is : "+ razorPayment.pay());


        //**** Abstract Factory design Pattern ****
        //Car -> Hatchback/Sedan. HatchbackFactory SedanFactory. CarFactory (This will be your abstract factory)
        CarFactory sedaCarFactory = new SedanFactory();
        Car sedanCar =  sedaCarFactory.createCar();
        System.out.println("Sedan Car Creation Response:"+sedanCar.assemble());
        CarFactory hatchbackFactory = new HatchbackFactory();
        Car hatchbackCar = hatchbackFactory.createCar();
        System.out.println("Hatchback Car Creation Response:"+hatchbackCar.assemble());


        //**** Builder Design pattern ****
        //Simplifies construction of complex objects. Useful when constructor has many parameters to avoid telescoping constructor.
        //Improves readability, promotes immutability & maintainability.
        // Use case - e.g. building dynamic SQL, StingBuilder in Java.
        // You can use Lombok's @Builder annotation which works same way.
        Employee employee1 = Employee.builder().id(1).build();
        Employee employee2 = Employee.builder().id(1).name("ABC").build();






        /** Structural Design Patterns */

        //**** Adapter design pattern ***
        // Structural design pattern which acts as a bridge between 2 incompatible interfaces.
        //The components of adapter design pattern:
        //Target Interface: The interface expected by the client, defining the operations it can use.
        //Adaptee: The existing class with an incompatible interface that needs integration.
        //Adapter: Implements the target interface and uses the adaptee internally, acting as a bridge.
        //Client: Uses the target interface, unaware of the adapter or adaptee details.
        // So flow goes like this : Client -> Target -> Adapter <-> Adaptee
        LegacySoapAdapter legacySoapAdapter = new LegacySoapAdapter();
        System.out.println("Adapter design pattern output :"+legacySoapAdapter.callExternalApi());




        //**** Front Controller design pattern ****
        // This uses MVC design,that separates an application into three interconnected components (Model, View, Controller).
        // Model - CartModel will hold the data.
        // View - is used to display data to UI/Client
        // Controller - Controls the data flow. It takes updates from CartModel and sends to CartView for display.
        CartModel cartModel = new CartModel(213, 150.65f);
        CartView cartView = new CartView();
        CartController cartController = new CartController(cartModel,cartView);
        System.out.println("Initial cart details:"+cartView.displayCart(cartModel));
        cartController.setCartTotal(200.5F);
        cartController.updateCartView();
        System.out.println("Cart details after update:"+cartView.displayCart(cartModel));


        /** Behavioral Design Patterns */

        //**** Command design pattern ****

    }

}
