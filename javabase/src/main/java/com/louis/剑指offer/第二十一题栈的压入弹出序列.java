package com.louis.剑指offer;

import java.util.Stack;

public class 第二十一题栈的压入弹出序列 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int temp = 0;
        if (popA == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i<pushA.length ;i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[temp]) {   //一直弹出，直到为空
               stack.pop();
               temp = temp + 1;
            }
        }
        return  stack.isEmpty();
    }
}
