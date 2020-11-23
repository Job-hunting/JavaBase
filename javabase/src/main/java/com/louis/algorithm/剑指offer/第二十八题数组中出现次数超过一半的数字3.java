package com.louis.algorithm.剑指offer;

public class 第二十八题数组中出现次数超过一半的数字3 {
    public static int MoreThanHalfNum_Solution(int [] array){
        if (array.length<0){
            return 0;
        }
        int start = 0;
        int end = array.length-1;
        int middle = (start+end)/2;
        int index = Partition(array,start,end);


        while(index!=middle){
            if(index>middle){
                index = Partition(array,start,index-1);
            }
            else{
                index = Partition(array,index+1,end);
            }
        }
        int result = array[middle];

        int times = 0;
        for(int i=0;i<array.length;++i){
            if(array[i] == result)
                times++;
        }
        if(times*2<array.length){
            return 0;
        }else{
            return result;
        }
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
