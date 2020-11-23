package com.louis.algorithm.letcode;

/**
 * @author duansaisai
 * @date 2020-10-25 23:59
 */
public class 二进制中1的个数 {
    public int hammingWeight(int n) {
        int count = 0;
        String bin = Integer.toBinaryString(n);
        char[] chars = bin.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                count++ ;
            }
        }
        return count;
    }
}
