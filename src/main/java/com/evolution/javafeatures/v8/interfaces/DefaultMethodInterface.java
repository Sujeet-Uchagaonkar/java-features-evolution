package com.evolution.javafeatures.v8.interfaces;

public interface DefaultMethodInterface {

    // Concrete
    void add(int i ,int j);

    //default method : new feature in Java 8
    // This won't force to its classes who implemented this interface
    default void subtract(){
        System.out.println("Inside Subtract method of DefaultMethodInterface");
    }


}
