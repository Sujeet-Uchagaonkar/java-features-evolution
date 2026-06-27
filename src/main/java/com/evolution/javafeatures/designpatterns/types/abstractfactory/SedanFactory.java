package com.evolution.javafeatures.designpatterns.types.abstractfactory;

public class SedanFactory implements CarFactory{
    @Override
    public Sedan createCar() {
        return new Sedan();
    }
}
