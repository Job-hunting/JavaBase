package com.louis.algorithm.stackandqueue;

import java.util.Stack;

/**
 * 使用递归函数和栈操作逆序一个栈
 * */
public class GetAndRemoveLastElement {
    /**
     * 将栈stack的栈低元素返回并移除
     * */
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    /**
     * 逆序一个栈
     * */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return ;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        for (Integer s : stack) {
            System.out.println(s);
        }
    }
}
