package com.evolution.javafeatures.designpatterns.types.command;

public class TV implements Device{
    @Override
    public String turnOn() {
        return "TV is turned ON.";
    }

    @Override
    public String turnOff() {
        return "TV is turned OFF.";
    }
}
