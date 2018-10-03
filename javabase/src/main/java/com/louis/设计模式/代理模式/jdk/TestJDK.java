package com.louis.设计模式.代理模式.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDK {
    public static void main(String[] args) {
        final  UserDao userDao=new UserDaoImpl();
        UserDao proxy=(UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // TODO Auto-generated method stub
                System.out.println("invoke方法前做一些代理");
                method.invoke(userDao, args);
                System.out.println("invoke方法后做一些代理");
                return proxy;
            }
        });
        proxy.addUser();
    }
}
