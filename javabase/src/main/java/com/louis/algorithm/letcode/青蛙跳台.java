package com.louis.algorithm.letcode;

/**
 * @author duansaisai
 * @date 2020-10-18 21:34
 */
public class 青蛙跳台 {

    public int numWays(int n) {
        if(n < 0) {
            return n;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int arr[] = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n ; i++) {
            arr[i] = (arr[i-1] + arr[i-2])% 1000000007;
        }
        return arr[n];
    }

}
