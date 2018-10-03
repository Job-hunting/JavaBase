package com.louis.algorithm.other;

import java.util.LinkedList;

/**
 * 滑动窗口解决的问题
 * 给定数组arr和整数num，保证max(arr[i..j]) - min(arr[i..j])  <=num，其中max(arr[i..j])表示子数组 arr[i..j]中的最大值，min(arr[i..j])表示子数组arr[i..j]中的最小值。假定数组长为N，实现时间复杂度O(N)的解法。
 *
 * https://blog.csdn.net/hzd12368/article/details/53385427
 *
 * L .....R  max,min范围内达标，则缩小L，R仍达标
 * L......R  max，min范围内不达标，则扩大L R仍不达标
 * */
public class ChildSub {
    public static int getNum(int[] arr , int num){
        if (arr == null || arr.length == 0){
            return 0 ;
        }
        LinkedList<Integer> qmin = new LinkedList<Integer>();
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int i = 0;  //start
        int j = 0;  //end
        int res = 0;
        while(i < arr.length){
            while (j < arr.length){    //end往右扩，直到不能扩位置
                while(!qmin.isEmpty() && arr[qmax.peekLast()] >= arr[j] ){
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]){
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if(arr[qmax.getFirst()] - arr[qmin.getFirst()] > num){
                    break;
                }
                j++;
            }
            if(qmin.peekFirst() == i){  //最小值下标有没有过期
                qmin.pollFirst();
            }
            if(qmax.peekFirst() == i){   //最大值下标有没有过期
                qmax.pollFirst();
            }
            res += j - i;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr_test = {1,2,3,4,5,6,7,8,9};
        int num_test = 4;
        int res_test;
        res_test = getNum(arr_test,num_test);
        System.out.printf("res = %d",res_test);
    }


}
