package com.evolution.javafeatures.v8.main;

import com.evolution.javafeatures.v8.interfaces.DefaultMethodInterface;

public class DefaultMethodInInterfaceDemo1 implements DefaultMethodInterface {


    @Override
    public void add(int i, int j) {
        System.out.println("Inside add method of DefaultMethodInInterfaceDemo1 class");
    }

    @Override
    public void subtract(){
        System.out.println("Inside subtract method of DefaultMethodInInterfaceDemo1 class");
    }
}
