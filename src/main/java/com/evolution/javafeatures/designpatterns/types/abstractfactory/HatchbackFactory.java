package com.evolution.javafeatures.designpatterns.types.abstractfactory;

public class HatchbackFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Hatchback();
    }
}
