package com.louis.algorithm.letcode;

/**
 * @author duansaisai
 * @date 2020-10-18 22:25
 */
public class 旋转数组的最小数字二分查找实现 {
    public static int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        int mid = 0;
        while(left <= right) {
            mid = left + (right - left) /2;
            if (numbers[right] < numbers[mid]) {
                left = mid +1;
            } else if (numbers[right] > numbers[mid]) {
                right = mid;
            } else {
                right = right - 1;
            }
        }
        return numbers[mid];
    }



    public static void main(String[] args) {
        int []a={2,2,2,0,1};
        int index= minArray(a);
        System.out.println(index);
    }
}
