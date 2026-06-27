package com.evolution.javafeatures.designpatterns.types.builder;

import lombok.Getter;



// Flow of creating builder is as : Create PRODUCT (Employee). Create inner Static Builder class with setters and build method. Make employee constructor private to use only by builder class.

//Will act as a PRODUCT in builder design pattern. This will remain immutable.
@Getter
public final class Employee {

    private final int id; //Required
    private final String name; //Required
    private final String email; //Optional


    // Private constructor accessed only by Builder. We will ask Builder to provide details. This will force user to use builder.
    private Employee(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
    }

    public static Builder builder() {
        return new Builder();
    }


    // We will not provide any setters also to support immutability and force user to use builder.


    // This is static builder class
    public static final class Builder {
        private int id;
        private String name;
        private String email;

        private Builder() {}

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        // Final step : build the object and return Employee object.
        public Employee build(){
            return new Employee(this);
        }
    }
}
