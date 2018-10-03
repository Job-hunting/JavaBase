package com.louis.algorithm.sort;

import java.util.Arrays;
import java.util.Collection;

/**
 * https://blog.csdn.net/tiange_xiao/article/details/80820543
 * 给定一个数组arr， 和一个数num， 请把小于等于num的数放在数组的左边， 大于num的数放在数组的右边。
 * */
public class SplitArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3,4,2};
        int num = 4;
        System.out.println(Arrays.toString(arr));
        splitArray(arr,num);
        System.out.println(Arrays.toString(arr));
    }

    public static void splitArray(int arr[],int num) {
        if (arr == null || arr.length<2) {
            return;
        }
        int i = 0;
        int j = arr.length-1 ;
        while(i!=j) {
            while(i<j&&arr[j]>=num) {
                j--;
            }
            while(i<j&&arr[i]<=num) {
                i++;
            }
            swap(arr, i, j);
        }
    }

    public static void swap(int arr[], int i, int j ) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
