package com.louis.algorithm.recursionAndDynamic;

import java.util.HashMap;

/**
 *
 * 换钱的方法数
 * 【题目】
 * 给定数组arr，arr中所有的值都为正数且不重复。每个值代表
 * 一种面值的货币，每种面值的货币可以使用任意张，再给定一
 * 个整数aim代表要找的钱数，求换钱有多少种方法。
 *
 *arr=[5,10,25,1]，aim=20。
 * 一张5，后面的组成15
 * 两张5，后面的组成10
 *
 *
 * 200，100，         50，10，5，2，1   aim=1000
 * 后面的组成600，与前面两个数如何组合无关，说明是无后效性。index,aim确定，返回值就确定
 * 暴力求解，就是后面组成600多次使用了。
 *
 *
 * 暴力-》记忆化搜索-》图表搜索-》简化图表搜索
 *
 * */
public class Code_01_CoinsWay {

	public static int coins1(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		return process1(arr, 0, aim);  //0及其以后所有的钱
	}


	//暴力
	//index：可以任意自由使用index及其之后所有的钱
	//aim：目标签数
	//返回值：方法数
	//index和aim是可变参数
	public static int process1(int[] arr, int index, int aim) {
		int res = 0;
		if (index == arr.length) {
			res = aim == 0 ? 1 : 0; //aim==0,说明来到数组最后，说明前面的选择是正确的
		} else {
			for (int i = 0; arr[index] * i <= aim; i++) { //i是选择几张 arr[index]
				res += process1(arr, index + 1, aim - arr[index] * i); //出去arr[index] * i，剩下的要组成aim - arr[index] * i
			}
		}
		return res;
	}


	//key："index_aim"
	//value:在满足key的条件下的返回值
	//将上次计算的结果保存到map中，以防多次计算
	//记忆化搜索
	public static HashMap<String,Integer> map = new HashMap<>();
	public static int processMap(int[] arr, int index, int aim) {
		int res = 0;
		if (index == arr.length) {
			res = aim == 0 ? 1 : 0; //aim==0,说明来到数组最后，说明前面的选择是正确的
		} else {
			for (int i = 0; arr[index] * i <= aim; i++) { //i是选择几张 arr[index]
				int nextAim = aim - arr[index]*i;
				String key = String.valueOf(index+1) +"_"+String.valueOf(nextAim);
				if (map.containsKey(key)) {
					res = res + map.get(key);
				} else {
					res = res + processMap(arr, index+1, nextAim);
				}
			}
		}
		map.put(String.valueOf(index) + "_" + String.valueOf(aim), res);
		return res;
	}



	public static int coinsOther(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		return processOther(arr, arr.length - 1, aim);
	}

	public static int processOther(int[] arr, int index, int aim) {
		int res = 0;
		if (index == -1) {
			res = aim == 0 ? 1 : 0;
		} else {
			for (int i = 0; arr[index] * i <= aim; i++) {
				res += processOther(arr, index - 1, aim - arr[index] * i);
			}
		}
		return res;
	}

	public static int coins2(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] map = new int[arr.length + 1][aim + 1];
		return process2(arr, 0, aim, map);
	}

	public static int process2(int[] arr, int index, int aim, int[][] map) {
		int res = 0;
		if (index == arr.length) {
			res = aim == 0 ? 1 : 0;
		} else {
			int mapValue = 0;
			for (int i = 0; arr[index] * i <= aim; i++) {
				mapValue = map[index + 1][aim - arr[index] * i];
				if (mapValue != 0) {
					res += mapValue == -1 ? 0 : mapValue;
				} else {
					res += process2(arr, index + 1, aim - arr[index] * i, map);
				}
			}
		}
		map[index][aim] = res == 0 ? -1 : res;
		return res;
	}

	public static int coins3(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] dp = new int[arr.length][aim + 1];
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; arr[0] * j <= aim; j++) {
			dp[0][arr[0] * j] = 1;
		}
		int num = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= aim; j++) {
				num = 0;
				for (int k = 0; j - arr[i] * k >= 0; k++) {
					num += dp[i - 1][j - arr[i] * k];
				}
				dp[i][j] = num;
			}
		}
		return dp[arr.length - 1][aim];
	}

	public static int coins4(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] dp = new int[arr.length][aim + 1];
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; arr[0] * j <= aim; j++) {
			dp[0][arr[0] * j] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= aim; j++) {
				dp[i][j] = dp[i - 1][j];
				dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;  //如果减去左边的值不越界，则把左边的值加上
			}
		}
		return dp[arr.length - 1][aim];
	}

	public static int coins5(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[] dp = new int[aim + 1];
		for (int j = 0; arr[0] * j <= aim; j++) {
			dp[arr[0] * j] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= aim; j++) {
				dp[j] += j - arr[i] >= 0 ? dp[j - arr[i]] : 0;
			}
		}
		return dp[aim];
	}

	public static void main(String[] args) {
		int[] coins = { 10, 5, 1, 25 };
		int aim = 2000;

		long start = 0;
		long end = 0;
		start = System.currentTimeMillis();
		System.out.println(coins1(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

		start = System.currentTimeMillis();
		System.out.println(coinsOther(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

		aim = 20000;

		start = System.currentTimeMillis();
		System.out.println(coins2(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

		start = System.currentTimeMillis();
		System.out.println(coins3(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

		start = System.currentTimeMillis();
		System.out.println(coins4(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

		start = System.currentTimeMillis();
		System.out.println(coins5(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

	}

}
