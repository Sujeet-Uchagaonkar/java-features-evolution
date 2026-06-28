package com.evolution.javafeatures.designpatterns.types.command;

//Receiver which will receive command from invoker.
public interface Device {
    String turnOn();
    String turnOff();
}
