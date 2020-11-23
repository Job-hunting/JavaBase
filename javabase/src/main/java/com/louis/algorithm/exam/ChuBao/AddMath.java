package com.louis.algorithm.exam.ChuBao;

import java.util.ArrayList;

import java.util.Scanner;
/**
 * 1+6/3
 * 1-10/2+1
 *
 * */
public class AddMath {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        //获取输入
        String string = in.nextLine();
        char[]  chars = string.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        String temp = "";
        for (int i= 0 ;i<chars.length;i++) {
            if (chars[i] != '+' && chars[i] != '-' && chars[i] != '*' && chars[i] != '/') {
                temp = temp + chars[i];
            } else if (chars[i] == '+') {
                list.add(temp);
                temp = "";
                list.add(String.valueOf('+'));
            } else if (chars[i] == '-') {
                list.add(temp);
                temp = "";
                list.add(String.valueOf('-'));
            } else if (chars[i] == '*') {
                list.add(temp);
                temp = "";
                list.add(String.valueOf('*'));
            } else if (chars[i] == '/') {
                list.add(temp);
                temp = "";
                list.add(String.valueOf('/'));
            }
        }
        list.add(temp);

        int size = list.size();
        for(int i=0;i<size;i++){
           if ("+".equals(list.get(i))){
               int num1 = Integer.parseInt(list.get(i-1));
               int num2 = Integer.parseInt(list.get(i+1));
               int sum = num1 + num2;
               list.set(i-1,String.valueOf(sum));
               list.remove(i);
               list.remove(i);
               size--;
               size--;
               i--;
               if (size == i) {
                   break;
               }
           }
           if ("-".equals(list.get(i))){
                int num1 = Integer.parseInt(list.get(i-1));
                int num2 = Integer.parseInt(list.get(i+1));
                int sub = num1 - num2;
               list.set(i-1,String.valueOf(sub));
               list.remove(i);
               list.remove(i);
               size--;
               size--;
               i--;
            }
            if (size == i) {
                break;
            }
        }

        int sizeA = list.size();
        for(int i=0;i<sizeA;i++){
            if ("*".equals(list.get(i))){
                int num1 = Integer.parseInt(list.get(i-1));
                int num2 = Integer.parseInt(list.get(i+1));
                int multi = num1 * num2;
                list.set(i-1,String.valueOf(multi));
                list.remove(i);
                list.remove(i);
                sizeA--;
                sizeA--;
                i = i-1;
                if (sizeA == i) {
                    break;
                }
            }
            if ("/".equals(list.get(i))){
                int num1 = Integer.parseInt(list.get(i-1));
                int num2 = Integer.parseInt(list.get(i+1));
                int remove = num1 / num2;
                list.set(i-1,String.valueOf(remove));
                list.remove(i);
                list.remove(i);
                sizeA--;
                sizeA--;
                i = i-1;
                if (sizeA == i) {
                    break;
                }
            }

        }
        System.out.print(list.get(0));
    }
}
