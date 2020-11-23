package com.louis.algorithm.剑指offer;

public class 第三十三题丑数 {
    public static int GetUglyNumber_Solution(int index) {
        if(index<1){
            return 0;
        }
        int num = 1;
        int count = 0;
        while(count<index) {
            if(isUgly(num)) {
                count++;
            }
            num++;
        }
        return num-1;
    }

    public static boolean isUgly(int num){
        while(num%2 == 0) {
            num = num/2;
        }
        while(num%3 == 0) {
            num = num/3;
        }
        while(num%5 == 0) {
            num = num/5;
        }
        if(num == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(1));
    }
}
