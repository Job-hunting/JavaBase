package com.louis.algorithm.剑指offer;

/**
 * 最后还需要遍历一遍验证是否真的是大于二分之一，最后temp=1，不一定说明它就是结果，也可能是刚好赋值为1
 * */
public class 第二十八题数组中出现次数超过一半的数字 {
    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array == null) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }

        int result = array[0];
        int temp = 1;
        for (int i = 0; i<array.length;i++) {
            if (temp == 0) {
                result = array[i];
                temp++;
            } else  if(array[i] != result ){
                temp--;
            } else {
                temp++;
            }
        }

        int count = 0;
        for (int i=0;i<array.length;i++) {
            if (array[i] == result) {
                count++;
            }
        }
        if (count>(array.length/2)){
            return result;
        } else {
            return 0;
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{4,2,1,4,2,4};
        MoreThanHalfNum_Solution(array);
    }
}
