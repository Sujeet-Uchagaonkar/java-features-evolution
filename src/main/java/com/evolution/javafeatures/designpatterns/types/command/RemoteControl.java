package com.evolution.javafeatures.designpatterns.types.command;

import lombok.AllArgsConstructor;

//Invoker which will get called from Client
@AllArgsConstructor
public class RemoteControl {
    private Command command;

    //Calling this method will trigger the command
    public String pressButton(){
        return this.command.execute();
    }
}
