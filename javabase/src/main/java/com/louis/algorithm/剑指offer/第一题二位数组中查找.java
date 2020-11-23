package com.louis.algorithm.剑指offer;
/**
 *
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *
 * 注意：行是递增的，列是递增的。
 * 解题：从左上或者右上开始，这里是从右上，如果target > array,则往下移动，如果target<array ,则往左移动。
 * */
public class 第一题二位数组中查找 {

    public static boolean getFind(int target, int array[][]){
        int row = 0;
        int col = array[0].length-1;
        while(row<=array.length-1&&col>=0){
            if(target == array[row][col]){
                return true;
            } else  if(target>array[row][col]){
                row++;
            } else if(target<array[row][col]) {
                col--;
            }
        }
        return false;
    }
}
