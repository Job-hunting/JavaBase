package com.louis.algorithm.Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。比如
 * 长度为20的 金条，不管切成长度多大的两半，都要花费20个铜
 * 板。一群人想整分整块金 条，怎么分最省铜板？
 * 例如,给定数组{10,20,30}，代表一共三个人，整块金条长度为
 * 10+20+30=60. 金条要分成10,20,30三个部分。 如果， 先把长
 * 度60的金条分成10和50，花费60 再把长度50的金条分成20和30，花费50 一共花费110铜板。
 * 但是如果， 先把长度60的金条分成30和30，花费60 再把长度30
 * 金条分成10和20，花费30 一共花费90铜板。
 * 输入一个数组，返回分割的最小代价。
 *
 *
 * 算法思想：
 * 基于哈夫曼编码的思想，
 * (1) 首先构造小根堆
 * (2) 每次取最小的两个数（小根堆），使其代价最小。并将其和加入到小根堆中
 * (3) 重复(2)过程，直到最后堆中只剩下一个节点
 * 注意：代价不是最后一个值，而是所有非叶结点之和，即上面求得两两个结点之和
 * */
public class Less_Money {

	public static int lessMoney(int[]arr){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); //使用优先级队列
		int res = 0;
		int cur = 0;
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}
		while(pq.size()>1){
			//1-------------------------------------------------------------
			cur = pq.poll()+pq.poll();
			res += cur;
			//2-------------------------------------------------------------
			pq.add(cur);
		}
		return res;
	}
	public static void main(String[] args) {
		int arr[] = new int[] { 10, 20, 30 };//90
		System.out.println(lessMoney(arr));
	}

}
