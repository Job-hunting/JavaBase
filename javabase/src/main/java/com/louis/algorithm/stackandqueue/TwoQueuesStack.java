package com.louis.algorithm.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 两个队列实现栈
 * */
public class TwoQueuesStack {
    private Queue<Integer> queue;
    private Queue<Integer> help;

    public TwoQueuesStack() {
        queue = new LinkedList<Integer>();
        help = new LinkedList<Integer>();
    }

    public void push(int pushInt) {
        queue.add(pushInt);
    }

    public int peek() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        while (queue.size() != 1) {
            help.add(queue.poll());
        }
        int res = queue.poll();
        help.add(res);
        swap();
        return res;
    }

    public int pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        while (queue.size() > 1) {
            help.add(queue.poll());
        }
        int res = queue.poll();
        swap();
        return res;
    }

    private void swap() {
        Queue<Integer> tmp = help;
        help = queue;
        queue = tmp;
    }

}

