package com.louis.algorithm.剑指offer;

public class 第三十八题数字在排序数组中出现的次数3 {
    public static int GetNumberOfK(int [] array , int k){
        int length = array.length;
        int firstK = getFirst(array, k, 0, length-1);
        int lastK = getLastK(array, k, 0, length-1);
        if(firstK != -1 && lastK != -1){
            return lastK - firstK + 1;
        }
        return 0;
    }

    public static int getFirst(int[] array, int k, int left, int right){
        if(left>right) {
            return -1;
        }
        int mid= (left+right)/2;
        if(array[mid]>k) {
            return getFirst(array,k,left,mid-1);
         } else if(array[mid] < k){
            return getFirst(array,k, mid+1,right);
        } else if (mid-1>=0 && array[mid-1] == k) {
            return getFirst(array,k,left,mid-1);
        } else {
            return mid;
        }
    }

    //循环写法
    private static int getLastK(int [] array , int k, int start, int end){
        int length = array.length;
        int mid = (start + end) >> 1;
        while(start <= end){
            if(array[mid] > k){
                end = mid-1;
            }else if(array[mid] < k){
                start = mid+1;
            }else if(mid+1 < length && array[mid+1] == k){
                start = mid+1;
            }else{
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }

}
