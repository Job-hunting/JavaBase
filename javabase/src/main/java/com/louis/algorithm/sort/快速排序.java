package com.louis.algorithm.sort;

import java.util.Arrays;
/**
 * http://www.cnblogs.com/CBDoctor/p/4077574.html
 * 快速排序
 * */
public class 快速排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3,4,2};
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int arr[], int left, int right) {
        if(left>right) {
            return;
        }
        int i = left;
        int j = right;
        int temp = arr[left];
        while(i!=j) {
            while(i<j&&arr[j]>=temp) {
                j--;
            }
            swap(arr, i, j);
            while(i<j&&arr[i]<=temp) {
                i++;
            }
            swap(arr, i, j);
        }

        quickSort(arr,left,i-1);
        quickSort(arr,j+1,right);

    }


    public static void swap(int arr[], int i, int j ) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
