package com.louis.algorithm.剑指offer;

public class 第三十八题数字在排序数组中出现的次数2 {
    public static int GetNumberOfK(int [] array , int k){
        return search(array, k+0.5) - search(array,k-0.5);
    }

    public static int search(int [] array , double k) {
        int left = 0 ;
        int right = array.length - 1;
        while(left<=right) {
            int mid = (left + right)/2;
            if(array[mid] > k) {
                right = mid-1;
            }
            if(array[mid] < k) {
                left = mid + 1;
            }
        }
        return left;
    }
}
