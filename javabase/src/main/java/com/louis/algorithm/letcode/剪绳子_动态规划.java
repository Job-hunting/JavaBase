package com.louis.algorithm.letcode;

/**
 * @author duansaisai
 * @date 2020-10-25 22:54
 */
public class 剪绳子_动态规划 {
    public static  int cuttingRope(int n) {
        int arr[]  =  new int[n+ 1];

        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i/2 ; j ++) {
                arr[i] = Math.max(arr[i], Math.max(j * arr[i-j], j * (i-j)));
            }
        }
        return arr[n];
    }


    public static void main(String[] args) {
        cuttingRope(10);
    }
}
