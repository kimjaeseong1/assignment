package com.example.withfhture;

import java.io.Serializable;

public class Singleton implements Serializable {
    private static final long serialVersionUID = 100;


    private static Singleton instance = new Singleton();


    private Singleton() {

        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance.");
        }
    }


    public static Singleton getInstance() {
        return instance;
    }


    protected Object readResolve() {
        return instance;
    }


}
