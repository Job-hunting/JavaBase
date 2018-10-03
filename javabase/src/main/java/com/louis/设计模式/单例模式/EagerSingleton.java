package com.louis.设计模式.单例模式;

public class EagerSingleton {
    private static EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton(){

    }

    public static EagerSingleton getEagerSingleton(){
        return eagerSingleton;
    }
}
