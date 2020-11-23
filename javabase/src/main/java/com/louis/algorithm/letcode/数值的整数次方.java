package com.louis.algorithm.letcode;

/**
 * @author duansaisai
 * @date 2020-10-27 15:58
 */
public class 数值的整数次方 {
    public double myPow(double x, int n) {
        long N = n;
        if (x == 0) {
            return 1;
        }
        if (N == 0) {
            return 1;
        }
        if (N < 0) {
            return 1 / pow(x, -N);
        } else {
            return pow(x, N);
        }
    }


    private double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }

        // 根据指数是奇数还是偶数进行分类讨论
        // 使用位运算的 与 运算符代替了求余数运算

        if ((n % 2) == 0) {
            double temp = pow(x, n/2);
            return temp * temp;
        } else {
            double temp = pow(x, (n-1)/2);
            return temp * temp * x;
        }
    }
}
