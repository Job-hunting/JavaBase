package com.louis.剑指offer;
/**
 *
 * 1、遍历第一次计算奇数的个数count
 * 2、新建矩阵temp[]
 * 3、再遍历一次array[] ,如果是奇数则从头开始放置，如果是偶数则从count开始放
 * */
public class 第十三题调整数组顺序使奇数位于偶数前面 {
    public void reOrderArray(int [] array) {
        int count = 0;
        for (int i =0; i< array.length ; i++) {
            if (array[i] % 2 !=0) {
                count ++;
            }
        }
        int[] temp = new int[array.length];
        int t = 0;
        for (int i =0; i< array.length ; i++) {
            if (array[i] % 2 != 0) {
                temp[t++] = array[i];
            } else {
                temp[count++] = array[i];
            }
        }
        for (int i =0; i< array.length ; i++) {
            array[i] = temp[i];
        }
    }
}
