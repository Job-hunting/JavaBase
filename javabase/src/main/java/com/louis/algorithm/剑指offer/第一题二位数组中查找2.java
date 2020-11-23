package com.louis.algorithm.剑指offer;

/**
 * 一种是：
 * 把每一行看成有序递增的数组，
 * 利用二分查找，
 * 通过遍历每一行得到答案，
 * 时间复杂度是nlogn
 *
 * 注意: 在判断left<=right时，是有等号的，不然的话。 left的初始位置的数字就没有对比过。
 * */

public class 第一题二位数组中查找2 {
    public static void main(String[] args) {
        int[][] array ={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Find(1,array);
    }

    public static  boolean Find(int target, int [][] array) {
        for(int i = 0 ;i <array.length; i++){
            int left = 0;
            int right = array[i].length-1;
            while(left<=right){
                int mid = (left+right)/2;
                if(target>array[i][mid]){
                    left = mid+1;
                } else if(target<array[i][mid]) {
                    right = mid -1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
