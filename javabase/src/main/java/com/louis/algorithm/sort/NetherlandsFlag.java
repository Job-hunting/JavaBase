package com.louis.algorithm.sort;

import java.util.Arrays;

/**
 * 和一个数num，请把小于num的数放在数组的 左边，等于num的数放在数组的中间，大于num的数放在数组的 右边。
 * 要求额外空间复杂度O(1)，时间复杂度O(N)。
 *
 * 设置三个指针，less表示小于区域，more表示大于区域，cur表示当前数
 * 1、如果cur值小于num,则cur值与less的下一个值进行交换
 * 2、如果cur值==num,则cur++；
 * 3、如果cur值大于num,则cur值与more范围的前一个值进行交换。注意此时cur没有++,因为cur值与x换位置后，还需要继续比较x的值，x还是个位置的数据
 * */
public class NetherlandsFlag {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,5,3,4,2,3};
        int num = 3;
        System.out.println(Arrays.toString(arr));
        netherLands(arr,num);
        System.out.println(Arrays.toString(arr));
    }

    public static void netherLands(int arr[],int num) {
        int less = -1;
        int more = arr.length;
        int cur = 0;
        while(cur!=more) {
            if(arr[cur]<num) {
                swap(arr, cur, less+1);
                less++;
                cur++;
            } else if (arr[cur] == num) {
                cur++;
            } else {
                swap(arr, cur, more-1);
                more--;
            }
        }
    }

    public static void swap(int arr[], int i, int j ) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
