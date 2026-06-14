package com.evolution.javafeatures.designpatterns.beans;

import java.util.Objects;

public class SingletonDemoBean {

    // Static member to hold the single instance
    private static SingletonDemoBean singletonDemoBean;

    // Private constructor to prevent external instantiation
    private SingletonDemoBean(){}

    public static SingletonDemoBean getInstance(){
        return (Objects.nonNull(singletonDemoBean) ? singletonDemoBean : new SingletonDemoBean());
    }
}
