package com.louis.algorithm.letcode;

/**
 * @author duansaisai
 * @date 2020-10-25 22:54
 */
public class 剪绳子_递归 {
    public static  int cuttingRope(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        return multi(n);
    }

    public static int multi(int target) {
        if (target<4) {
            return target;
        }
        int max = 0;
        for (int i = 1; i <= target /2; i++) {
            max = Math.max(max, multi(target - i) * multi(i) );
        }
        return max;
    }

    public static void main(String[] args) {
        cuttingRope(10);
    }
}
