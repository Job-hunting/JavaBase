package com.louis.algorithm.other;

import java.util.HashMap;
/**
 *
 *给定一个数组arr，和一个整数num，求在arr中，累加和等于num的最长
 * 子数组的长度
 * 例子：
 * arr = {7,3,2,1,1,7,7,7} num = 7
 * 其中有很多的子数组累加和等于7，但是最长的子数组是{3,2,1,1}，所
 * 以返回其长度4
 *
 *
 * 一般解子数组问题，都以i节点结尾的值
 *
 *
 * 扩展：求最长的奇数个数和偶数个数最长子数组。化成-1 1 累加成0
 * */
public class LongestSumSubArrayLength {

	public static int maxLength(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1); // important
		int len = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum - k)) {
				len = Math.max(i - map.get(sum - k), len);
			}
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return len;
	}

	public static int[] generateArray(int size) {
		int[] result = new int[size];
		for (int i = 0; i != size; i++) {
			result[i] = (int) (Math.random() * 11) - 5;
		}
		return result;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = generateArray(20);
		printArray(arr);
		System.out.println(maxLength(arr, 10));

	}

}
