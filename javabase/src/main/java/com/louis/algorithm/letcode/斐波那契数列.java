package com.louis.algorithm.letcode;

/**
 * @author duansaisai
 * @date 2020-10-12 23:50
 */
public class 斐波那契数列 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return (fib(n-1) + fib(n-2)) % 1000000007;
    }
}
