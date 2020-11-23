package com.louis.algorithm.剑指offer;

import java.util.ArrayList;
/**
 * 快速排序的思想
 * */
public class 第二十九题最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input.length<0 || k > input.length || k<=0){
            return result;
        }
        int start = 0;
        int end = input.length-1;
        int index = Partition(input,start,end);
        while(index != k-1) {
            if (k-1<index) {
                index = Partition(input,start,index-1);
            }
            if (k-1>index) {
                index = Partition(input, index+1, end);
            }
        }
        for (int i = 0; i <= index;i++){
            result.add(input[i]);
        }
        return result;
    }

    public static int Partition(int arr[], int start, int end) {
        int temp = arr[start];
        while(start!=end) {
            while(start<end && arr[end]>=temp) {
                end--;
            }
            swap(arr,start,end);
            while(start<end && arr[start]<= temp) {
                start++;
            }
            swap(arr,start,end);
        }
        return start;
    }
    public static void swap(int arr[], int i, int j ) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
