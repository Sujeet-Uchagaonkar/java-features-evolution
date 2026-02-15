package com.evolution.javafeatures.v20.main;

public class SwitchCaseFeaturesDemo {

    public static void main(String[] args) {

        // Pattern Matching for switch allows switch statements and expressions to
        // match types and conditions directly, making code more concise and type-safe.

        Object contactDetail = 9876543210L;

        String givenContactDetail = switch (contactDetail){
            //Type Pattern & guarded pattern : when we check type of input and extra guarded condition : s.contains("@")
            case String s when s.contains("@") -> "Email";
            case Long l when l.toString().length() == 10 -> "Mobile";
            case null -> "Not provided"; // Null handling
            default -> "Unknown type";
        };

        System.out.println("Given contact details is of type: "+givenContactDetail);

    }

}
