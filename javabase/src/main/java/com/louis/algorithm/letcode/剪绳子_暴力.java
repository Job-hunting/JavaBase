package com.louis.algorithm.letcode;

/**
 * @author duansaisai
 * @date 2020-10-25 22:54
 */
public class 剪绳子_暴力 {
    public int cuttingRope(int n) {
        if (n<=2) {
            return 1;
        }
        int res = -1;
        for (int i = 2; i < n; i++) {
            res =  Math.max(res, Math.max(i * (n-i), i*cuttingRope(n-i)));
        }
        return res;
    }
}
