package com.evolution.javafeatures.v8.main;

import com.evolution.javafeatures.v8.interfaces.DefaultMethodInterface;

public class DefaultMethodInInterfaceDemo2 implements DefaultMethodInterface {
    @Override
    public void add(int i, int j) {
    System.out.println("Inside add method of DefaultMethodInInterfaceDemo2 class");
    }
}
