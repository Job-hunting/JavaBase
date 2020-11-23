package com.louis.algorithm.letcode;

/**
 * @author duansaisai
 * @date 2020-10-18 22:15
 */
public class 二分查找算法 {
    public static int binarySearch(int []a,int num) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (a[mid] == num) {
                return mid;
            } else if (a[mid] < num){
                left = mid +1;
            } else {
                right = mid -1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int []a={1,10,30,34,40,45,59};
        int index= binarySearch(a, 30);
        System.out.println(index);
    }
}
