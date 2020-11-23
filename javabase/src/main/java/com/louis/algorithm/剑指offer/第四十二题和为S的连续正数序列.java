package com.louis.algorithm.剑指offer;

import java.util.ArrayList;

public class 第四十二题和为S的连续正数序列 {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        int min = 1;
        for(;min<=sum;min++){
            ArrayList<Integer> list = new ArrayList<>();
            int temp = 0;
            int max = min+1;
            temp = min+max;
            while(temp<sum){
                max++;
                temp = temp+max;
            }
            if(temp>sum){
                continue;
            }
            if (temp==sum){
                for(int i = min; i<=max; i++) {
                    list.add(i);
                }
                result.add(list);
            }

        }
       return result;
    }

    public static void main(String[] args) {
        FindContinuousSequence(4);
    }
}
