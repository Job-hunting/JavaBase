package com.louis.algorithm.letcode;

/**
 * @author duansaisai
 * @date 2020-10-12 23:50
 */
public class 斐波那契数列动态规划 {
    public int fib(int n) {
        int arr[] = new int[n + 1];
        if (n<=1) {
            return n;
        }
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i-1] % 1000000007) + (arr[i-2]% 1000000007);
        }
        return arr[n] % 1000000007;
    }

}
