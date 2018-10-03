package com.louis.algorithm.other;
/**
 * 给定一个数组arr，全是正数；一个整数aim，求累加和等
 * 于aim的，最长子数组，要求额外空间复杂度O(1)，时间
 * 复杂度O(N)
 *
 *
 * 与可负可0那个题是有区别的
 * */
public class LongestSumSubArrayLengthInPositiveArray {
/**
 *
 * 设置两个指针，进行扩展
 * */
	public static int getMaxLength(int[] arr, int k) {
		if (arr == null || arr.length == 0 || k <= 0) {
			return 0;
		}
		int L = 0;
		int R = 0;
		int sum = arr[0];
		int len = 0;
		while (R < arr.length) {
			if (sum == k) {  //=  左边扩展，当然右边扩展也可以
				len = Math.max(len, R - L + 1);
				sum -= arr[L++];
			} else if (sum < k) {  //sum < aim，右边扩
				R++;
				if (R == arr.length) {   //保证R不越界
					break;
				}
				sum += arr[R];
			} else {  //sum>aim  ,左边扩
				sum -= arr[L++];
			}
		}
		return len;
	}

	public static int[] generatePositiveArray(int size) {
		int[] result = new int[size];
		for (int i = 0; i != size; i++) {
			result[i] = (int) (Math.random() * 10) + 1;
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
		int len = 20;
		int k = 15;
		int[] arr = generatePositiveArray(len);
		printArray(arr);
		System.out.println(getMaxLength(arr, k));

	}

}
