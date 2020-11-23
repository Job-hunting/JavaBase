package com.louis.algorithm.剑指offer;

public class 第四十一题数组中只出现一次的数字 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length<1) {
            return;
        }
        int temp = 0;
        for (int i = 0; i<array.length; i++) {
            temp = temp^array[i];
        }
        int index = findIndex(temp);
        for (int i = 0; i<array.length; i++) {
            if(isBit(array[i],index)){
                num1[0] = num1[0]^array[i];
            } else {
                num2[0] = num2[0]^array[i];
            }
        }
    }

    public static int findIndex(int num){
        int index = 0;
        while((index & 1) == 0) {
            num = num>>1;
            index++;
        }
        return index;
    }

    public static boolean isBit(int num, int index) {
        num = num>>index;
        return (num&1) == 1;
    }
}
