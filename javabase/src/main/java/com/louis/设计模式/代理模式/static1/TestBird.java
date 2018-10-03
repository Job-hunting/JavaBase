package com.louis.设计模式.代理模式.static1;

public class TestBird {
    public static void main(String[] args) {
        Fly bird=new Bird();
        ProxyBird proxyBird=new ProxyBird();
        proxyBird.setBird(bird);
        proxyBird.fly();
    }
}


