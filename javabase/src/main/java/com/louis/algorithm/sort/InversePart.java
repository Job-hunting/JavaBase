package com.louis.algorithm.sort;

import java.util.Arrays;

/**
 * 牛客题：
 * https://www.cnblogs.com/SkyeAngel/p/8715987.html
 * 逆序对问题
 * 如果需要统计有多少个逆序对，还需要主要可能溢出的情况，使用long类型。return (int)(res % 1000000007);
 * */
public class InversePart {
    public static void main(String[] args) {
        int arr [] = new int[]{9,8,7};
        System.out.println(Arrays.toString(arr));
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static  void sort(int arr[],int left, int right) {
        if (left == right) {
            return ;
        }
        int mid = (left+right)/2;
        sort(arr,left,mid);
        sort(arr, mid+1, right);
        merge(arr, left, mid ,right);
    }

    public static void merge(int arr[], int left, int mid, int right){
        int[] help = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int t = 0;
        while(i<=mid&&j<=right) {
            if(arr[i]<=arr[j]){
                help[t++] = arr[i++];
            } else {
                for (int x = i; x<=mid;x++){
                    System.out.println(arr[x]+"-"+arr[j]);
                }
                help[t++] = arr[j++];
            }
        }
        while(i<=mid){
            help[t++] = arr[i++];
        }
        while(j<=right){
            help[t++] = arr[j++];
        }

        t=0;
        while(left<=right){
            arr[left++] = help[t++];
        }

    }
}
