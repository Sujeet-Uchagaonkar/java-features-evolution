package com.evolution.javafeatures.designpatterns.types.command;

import lombok.AllArgsConstructor;

//Concrete interface
@AllArgsConstructor
public class TurnOffCommand implements Command{
    Device device;

    @Override
    public String execute() {
        return this.device.turnOff();
    }
}
