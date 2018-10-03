package com.louis.algorithm.sort;

/**
 * 插入排序
 *  第N-1次，数组前N-1个元素组成有序的数组，将数组的第N个元素插入由N-1个元素构成的有序数组中
 * */
public class InsertionSort {
    //插入排序算法
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
