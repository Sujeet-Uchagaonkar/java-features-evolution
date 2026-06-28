package com.evolution.javafeatures.designpatterns.types.command;

// Command Interface which will be implemented by Concrete interfaces - TurnOnCommand & TurnOffCommand.
public interface Command {
    String execute();
}
