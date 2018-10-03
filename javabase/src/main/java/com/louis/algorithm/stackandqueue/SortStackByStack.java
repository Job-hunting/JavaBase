package com.louis.algorithm.stackandqueue;

import java.util.Stack;
/**
 *  最终排序后help栈顶是最小值，栈低是最大值
 *  stack 栈顶是最大值，栈低是最小值
 *  栈的遍历先从底部开始遍历，低是0
 *
 *  算法思想：
 * 1、如果cur<=help的栈顶元素，则将cur直接压入help
 * 2、如果cur>=help的栈顶元素，则将help的元素弹出并压入stack,直到cur<=help的栈顶元素，然后再讲cur压入help中
 * */
public class SortStackByStack {
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek()<cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());  //栈顶是最大值，栈低是最小值
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(4);
        sortStackByStack(stack);

        for (Integer s : stack) {
            System.out.println(s);
        }
    }
}
