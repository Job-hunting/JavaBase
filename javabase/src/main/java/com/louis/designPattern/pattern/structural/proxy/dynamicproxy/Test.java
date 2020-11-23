package com.louis.designPattern.pattern.structural.proxy.dynamicproxy;

import com.louis.designPattern.pattern.structural.proxy.IOrderService;
import com.louis.designPattern.pattern.structural.proxy.Order;
import com.louis.designPattern.pattern.structural.proxy.OrderServiceImpl;

/**
 * Created by geely
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
//        order.setUserId(2);
        order.setUserId(1);
        IOrderService orderServiceDynamicProxy = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();

        orderServiceDynamicProxy.saveOrder(order);
    }
}
