package com.evolution.javafeatures.v14.main;

import com.evolution.javafeatures.v14.entity.PersonRecord;

public class RecordDemo {

    public static void main(String[] args) {
        // Records are special type of classes with immutable behaviour
        // to reduce boilerplate code and simplify the creation of data carrier classes, such as POJOs and DTOs
        PersonRecord p1 = new PersonRecord(1, "John");

        System.out.println("Record of person is: Id: " + p1.id() + " & Name: " + p1.name());

    }

}
