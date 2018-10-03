package com.louis.algorithm.other;

import java.util.Stack;

/**
 * 　给定一个整型矩阵map，其中的值只有0,1两种，求全是1 的所有矩阵区域中，最大的矩形区域为1的数量。
 *  首先，矩阵的行数为N，以每一行作为分割，统计以当前行作为底的情况下，每个位置往上的1 的数量，使用高度数组 height 来表示。
 * 其次，对于每一次分割，都利用更新后的height数组来求出每一行为底的情况下，最大的矩形的大小。这一步的实质就是在直方图中求最大矩形的面积，找到柱子左边刚比它小的柱子位置，以及右边刚比它大的柱子位置，用栈计算最快。
 * */
public class MaxSubRecSize {
    //height数组表示在以当前行作为底的情况下，每个位置往上的连续的 1 的数量
    public int maxRecSize(int[][] map){
        if (map==null || map.length==0 || map[0].length==0){
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i=0; i<map.length; i++){
            for (int j=0; j<map[0].length; j++){
                height[j] = map[i][j]==0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;
    }

    //找到柱子左边刚比它小的柱子位置，以及右边刚比它大的柱子位置，用栈计算最快
    private int maxRecFromBottom(int[] height){
        if (height==null || height.length==0){
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i=0; i<height.length; i++){
            while (!stack.isEmpty() && height[i]<=height[stack.peek()]){
                int j = stack.pop();//不断循环，直到当前位置的值大于栈顶元素
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k + 1) * height[j];
                maxArea = Math.max(curArea, maxArea);
            }
            stack.push(i);
        }

      // 针对的是从栈底到栈顶一直递增的情况
        while (!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k + 1) * height[j];
            maxArea = Math.max(curArea, maxArea);
        }
        return maxArea;
    }

}
