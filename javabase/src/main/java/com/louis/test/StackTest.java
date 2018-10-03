package com.louis.test;

import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {

//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.add(4);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
        System.out.println(getInt());
    }

    public static int getInt(){
        try{
            return 3;
        }catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

}
