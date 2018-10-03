package com.louis.algorithm.sort;

import java.util.Arrays;

/**
 *  构造大顶堆的时间复杂度是o(n).计算方法是0（log1）+o(log2)+...+o(logn) 收敛于o(n)
 *  heapInsert（）是向堆中增加节点，需要依次调整堆结构。从低往上
 *  heapify（）是堆中的一个数发生了变化，重新调整堆结构。从上往低
 * */
public class 堆排序 {
    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static  void sort(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            heapInsert(arr, i);
        }

        int size = arr.length -1;
        swap(arr, 0, size);
        while(size >0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void heapInsert(int arr[], int index) {
       while (arr[(index-1)/2] < arr[index] ) {
            swap(arr, index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    public static void heapify(int arr[], int index, int heapSize){
        int left =  2*index+1;
        while(left<heapSize) {
            int largest = left;
            if(left+1<heapSize){
                largest = arr[left]>arr[left+1]?left:left+1;
            }
            if(arr[largest]<arr[index]) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left =  2*index+1;
        }
    }

    public static void swap(int arr[], int i, int j ) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
