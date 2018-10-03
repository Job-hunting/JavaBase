package com.louis.algorithm.other;

import java.util.HashMap;
/***
 *
 * 给定一个数组arr，值可正，可负，可0；一个整数aim，求累加
 * 和小于等于aim的，最长子数组，要求时间复杂度O(N)
 *
 * */
public class LongestSubarrayLessSumAwesomeSolution {

	public static int maxLengthAwesome(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int[] sums = new int[arr.length];
		int[] ends = new int[arr.length];
		sums[arr.length - 1] = arr[arr.length - 1];
		ends[arr.length - 1] = arr.length-1;
		for (int i = arr.length - 2; i >= 0; i--) { //从右往左算
			if (sums[i + 1] < 0) {
				sums[i] = arr[i] + sums[i + 1];
				ends[i] = ends[i+1];   //前一个右边界的位置
			} else {
				sums[i] = arr[i];
				ends[i] = i;
			}
		}
		//针对上面两个数组进行扩
		int end = 0;  //扩到的右边界
		int sum = 0;
		int res = 0;  //长度
		for (int i = 0; i < arr.length; i++) {  //从i位置扩
			while (end < arr.length && sum + sums[end] <= k) {
				sum += sums[end];
				end = ends[end] + 1;
			}
			sum -= end > i ? arr[i] : 0;
			res = Math.max(res, end - i);
			end = Math.max(end, i + 1);
		}
		return res;
	}

	public static int maxLength(int[] arr, int k) {
		int[] h = new int[arr.length + 1];
		int sum = 0;
		h[0] = sum;
		for (int i = 0; i != arr.length; i++) {
			sum += arr[i];
			h[i + 1] = Math.max(sum, h[i]);
		}
		sum = 0;
		int res = 0;
		int pre = 0;
		int len = 0;
		for (int i = 0; i != arr.length; i++) {
			sum += arr[i];
			pre = getLessIndex(h, sum - k);
			len = pre == -1 ? 0 : i - pre + 1;
			res = Math.max(res, len);
		}
		return res;
	}

	public static int getLessIndex(int[] arr, int num) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		int res = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] >= num) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return res;
	}

	// for test
	public static int[] generateRandomArray(int len, int maxValue) {
		int[] res = new int[len];
		for (int i = 0; i != res.length; i++) {
			res[i] = (int) (Math.random() * maxValue) - (maxValue / 3);
		}
		return res;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1000000; i++) {
			int[] arr = generateRandomArray(10, 20);
			int k = (int) (Math.random() * 20) - 5;
			if (maxLengthAwesome(arr, k) != maxLength(arr, k)) {
				System.out.println("oops!");
			}
		}

	}

}
