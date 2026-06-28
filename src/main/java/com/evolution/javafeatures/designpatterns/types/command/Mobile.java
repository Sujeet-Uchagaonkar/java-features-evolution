package com.evolution.javafeatures.designpatterns.types.command;

public class Mobile implements Device {
    @Override
    public String turnOn() {
        return "Mobile is turned ON.";
    }

    @Override
    public String turnOff() {
        return "Mobile is turned OFF.";
    }
}
