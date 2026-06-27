package com.evolution.javafeatures.designpatterns.types.abstractfactory;

public class Sedan implements Car{
    @Override
    public String assemble() {
        return "Sedan assembled!!";
    }
}
