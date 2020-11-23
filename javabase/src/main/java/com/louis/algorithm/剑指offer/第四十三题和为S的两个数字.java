package com.louis.algorithm.剑指offer;

import java.util.ArrayList;

public class 第四十三题和为S的两个数字 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if(array == null || array.length<2){
            return result;
        }
        int i = 0 ;
        int j = array.length-1;
        while(i<j) {
            int temp = array[i] + array[j];
            if(temp>sum) {
                j--;
            } else if(temp<sum){
                i++;
            } else {
                result.add(array[i]);
                result.add(array[j]);
                break;
            }
        }
       return result;
    }
}
