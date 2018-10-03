package com.louis.剑指offer;

public class 第三十八题数字在排序数组中出现的次数 {
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == k) {
                count++;
            }
        }
        return count;
    }
}
