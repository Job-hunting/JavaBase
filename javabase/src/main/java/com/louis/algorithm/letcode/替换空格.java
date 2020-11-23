package com.louis.algorithm.letcode;

/**
 * @author duansaisai
 * @date 2020-10-11 22:17
 */
public class 替换空格 {
    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }
    public static String replaceSpace(String s) {
        char[] chars = s.toCharArray();

        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                count ++;
            }
        }
        char[] result = new char[chars.length + count * 2];
        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                result[k] = '%';
                k++;
                result[k] = '2';
                k++;
                result[k] = '0';
                k++;
                continue;
            }
            result[k] = chars[i];
            k++;
        }
        return String.valueOf(result);
    }
}
