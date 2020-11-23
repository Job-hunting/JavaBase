package com.louis.algorithm.剑指offer;

public class 第三十题连续子数组的最大和2 {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int res = array[0];
        int max = array[0];
        for (int i = 1;i<array.length;i++) {
            max = Math.max(max+array[i],array[i]);
            res = Math.max(max,res);
        }
        return res;
    }
}
