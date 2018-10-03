package com.louis.设计模式.代理模式.static1;

public class ProxyBird implements Fly{

    //维护一个被代理对象
    Fly bird;

    public Fly getBird() {
        return bird;
    }

    public void setBird(Fly bird) {
        this.bird = bird;
    }

    @Override
    public void fly() {
        // TODO Auto-generated method stub
        System.out.println("我代理增强一下你再飞~");
        bird.fly();
    }

}