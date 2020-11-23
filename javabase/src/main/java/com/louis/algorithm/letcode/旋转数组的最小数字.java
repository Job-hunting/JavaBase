package com.louis.algorithm.letcode;

/**
 * @author duansaisai
 * @date 2020-10-18 21:59
 */
public class 旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        int cur = numbers[numbers.length-1];
        for (int i = numbers.length - 2; i >= 0; i--) {
            if (numbers[i] > cur) {
                return cur;
            }
            cur = numbers[i];
        }
        return cur;
    }
}
