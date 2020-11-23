package com.louis.algorithm.剑指offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 大顶堆
 * */
public class 第二十九题最小的K个数2 {
    public static  ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k> input.length || k == 0) {
            return result;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i<input.length;i++) {
            if(priorityQueue.size() != k) {
                priorityQueue.offer(input[i]);
            } else if(priorityQueue.peek()>input[i]){
                priorityQueue.poll();
                priorityQueue.offer(input[i]);
            }

        }

        for (Integer integer : priorityQueue) {
            result.add(integer);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4,5,8,1,0,3};
        GetLeastNumbers_Solution(array,3);
    }
}
