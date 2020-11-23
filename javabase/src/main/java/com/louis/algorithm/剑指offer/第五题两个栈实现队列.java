package com.louis.algorithm.剑指offer;

import java.util.Stack;
/**
 * 先判断stack2是否为空，如果不为空，则从stack2中弹出，否则先从stack1的所有数据弹入到stack2中，再弹出
 *
 * */
public class 第五题两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    Stack<Integer> temp = new Stack<>();
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("empty");
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
