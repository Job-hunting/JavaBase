package com.louis.algorithm.剑指offer;

/**
 * 使用二分查找，需要判断中间数与最后一个数字相同的话，就不知道是往前移动还是往后移动了，这里的处理是
 * right= right -1；
 *
 * */
public class 第六题旋转数组的最小数字 {
    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length -1;
        while(left <= right) {
            int mid = (left+right)/2;
            if(array[mid] > array[right]) {
                left = mid + 1;
            } else if (array[mid] == array[right]) {
                right = right -1;
            } else {
                right = mid;
            }
        }
        return array[left];
    }
}
