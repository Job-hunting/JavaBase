package com.louis.algorithm.剑指offer;

public class 第三十六数组中的逆序对 {
    public static int InversePairs(int [] array) {
        int[] temp = new int[array.length];
        return (int)(sort(array, 0, array.length-1, temp)%1000000007);
    }

    public static long sort(int[] array, int left, int right, int[] temp){
        if(left<right) {
            int mid = (left+right)/2;
            return sort(array,left,mid,temp) +
                    sort(array,mid+1,right,temp) +
                    merge(array,left,mid,right,temp);
        }
        return 0;
    }

    private static long merge(int[] array, int left, int mid, int right, int[] temp){
        int i = left;
        int j = mid+1;
        int t = 0;
        long count = 0;
        while(i<=mid && j<=right) {
            if(array[i]<array[j]){
                temp[t++] = array[i++];
            } else {
                temp[t++] = array[j++];
                count = count + right-j+1;
            }
        }
        while(i<=mid) {
            temp[t++] = array[i++];
        }
        while(j<=right) {
            temp[t++] = array[j++];
        }
        t =  0;
        while(left<=right) {
            array[left++] = temp[t++];
        }
        return count;
    }
}
