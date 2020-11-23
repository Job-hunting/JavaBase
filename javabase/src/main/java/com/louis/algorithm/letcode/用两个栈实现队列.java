package com.louis.algorithm.letcode;//package com.louis.algorithm.letcode;
//
//import java.util.Stack;
//
///**
// * @author duansaisai
// * @date 2020-10-12 23:34
// */
//public class 用两个栈实现队列 {
//    Stack<Integer> stack1;
//    Stack<Integer> stack2;
//
//    public CQueue() {
//        stack1 = new Stack<>();
//        stack2 = new Stack<>();
//    }
//
//    public void appendTail(int value) {
//        stack1.push(value);
//    }
//
//    public int deleteHead() {
//        if (!stack2.isEmpty()) {
//            return stack2.pop();
//        } else {
//            if (stack1.isEmpty()) {
//                return -1;
//            }
//            while (!stack1.isEmpty()) {
//                stack2.push(stack1.pop());
//            }
//            return stack2.pop();
//        }
//    }
//}
