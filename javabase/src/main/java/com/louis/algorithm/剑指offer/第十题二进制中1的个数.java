package com.louis.algorithm.剑指offer;
/**
 * 对1进行扩展
 * */
public class 第十题二进制中1的个数 {
    public static void main(String[] args) {
        NumberOf1(-10);
    }
    public static int NumberOf1(int n) {
        int result = 0;
        int flag = 1;
        while(flag !=0) {
            if((n & flag) !=0) {
                result++;
            }
            flag = flag<<1;
        }
        return result;
    }
}
