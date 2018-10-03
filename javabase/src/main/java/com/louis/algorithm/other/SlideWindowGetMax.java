package com.louis.algorithm.other;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * 滑动窗口问题
 *https://blog.csdn.net/u010429424/article/details/73692248
 *
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口：{[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}，他们的最大值分别为{4,4,6,6,6,5}。
 * */
public class SlideWindowGetMax {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();

        if(num == null || num.length == 0 || size == 0 || size > num.length) {
            return result;
        }

        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 0; i < num.length; i++) {
            if(!queue.isEmpty()){
                // 如果队列头元素不在滑动窗口中了，就删除头元素
                if(i >= queue.peek() + size) {
                    queue.pop();
                }

                // 如果当前数字大于队列尾，则删除队列尾，直到当前数字小于等于队列尾，或者队列空
                while(!queue.isEmpty() && num[i] >= num[queue.getLast()]) {
                    queue.removeLast();
                }
            }
            queue.offer(i); // 入队列

            // 滑动窗口经过三个元素，获取当前的最大值，也就是队列的头元素
            if(i + 1 >= size) {
                result.add(num[queue.peek()]);
            }
        }
        return result;
    }
}
