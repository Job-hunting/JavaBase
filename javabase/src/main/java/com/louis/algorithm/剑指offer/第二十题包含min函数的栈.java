package com.louis.algorithm.剑指offer;

import java.util.Stack;

public class 第二十题包含min函数的栈 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    int min = Integer.MAX_VALUE;
    public void push(int node) {
        if (node <min) {
            min = node;
        }
        stack1.push(node);
        stack2.push(min);
    }

    public void pop() {
        stack2.pop();
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
