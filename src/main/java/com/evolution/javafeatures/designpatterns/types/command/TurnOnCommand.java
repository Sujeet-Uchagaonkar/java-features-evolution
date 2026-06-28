package com.evolution.javafeatures.designpatterns.types.command;

import lombok.AllArgsConstructor;

//Concrete interface
@AllArgsConstructor
public class TurnOnCommand implements Command{
    Device device;

    @Override
    public String execute() {
        return this.device.turnOn();
    }
}
