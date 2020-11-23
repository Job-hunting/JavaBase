package com.louis.algorithm.剑指offer;

import java.util.Arrays;
/**
 * 先排序找中间的数
 * */
public class 第二十八题数组中出现次数超过一半的数字2 {
    public static int MoreThanHalfNum_Solution(int [] array){
        Arrays.sort(array);
        int mid = (0+array.length-1)/2;
        int temp = array[mid];
        int count=0;
        for (int i=0;i<array.length;i++) {
            if (array[i] == temp) {
                count++;
            }
        }
        if (count>(array.length/2)) {
            return temp;
        } else{
            return 0;
        }
    }
}
