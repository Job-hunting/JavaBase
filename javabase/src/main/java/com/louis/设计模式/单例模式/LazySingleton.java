package com.louis.设计模式.单例模式;

public class LazySingleton {
    private static LazySingleton instance = null;

    private LazySingleton(){

    }
    public static synchronized LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
