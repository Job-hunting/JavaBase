package com.louis.剑指offer;
/**
 * 将所有数字转化成字符串
 *
 * */
public class 第三十一题整数中1出现的次数 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int result = 0 ;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i<= n; i++) {
            sb.append(i);
        }
        String str = sb.toString();
        for (int i =0; i<str.length();i++) {
            if(str.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }
}
