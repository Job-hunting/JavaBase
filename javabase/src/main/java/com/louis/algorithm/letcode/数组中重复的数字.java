package com.louis.algorithm.letcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duansaisai
 * @date 2020-10-11 21:44
 */
public class 数组中重复的数字 {
    public static void main(String[] args) {

    }

    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length ; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 0);
            } else {
                return nums[i];
            }
        }
        return nums[0];

    }

}
