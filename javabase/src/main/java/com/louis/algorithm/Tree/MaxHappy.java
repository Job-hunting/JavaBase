package com.louis.algorithm.Tree;

import java.util.ArrayList;
import java.util.List;
/**
 * 一个公司的上下节关系是一棵多叉树，这个公司要举办晚会，你作为组织者已经摸清了大家的心理：一个员工的直
 * 接上级如果到场，这个员工肯定不会来。每个员工都有一个活跃度的值，决定谁来你会给这个员工发邀请函，怎么
 * 让舞会的气氛最活跃？返回最大的活跃值。
 *
 * 两个信息：头结点来的活跃值，头结点不来的活跃值
 * */
public class MaxHappy {

	public static class Node {
		public int huo;
		public List<Node> nexts;
		public Node(int huo){
			this.huo = huo;
			nexts = new ArrayList<>();
		}
	}

	public static int getMaxHuo(Node head){
		ReturnData data = process(head);
		return Math.max(data.bu_lai_huo,data.lai_huo);
	}

	public static class ReturnData{
		public int lai_huo;
		public int bu_lai_huo;

		public ReturnData(int lai_huo, int bu_lai_huo) {
			this.lai_huo = lai_huo;
			this.bu_lai_huo = bu_lai_huo;
		}
	}

	public static ReturnData process(Node head){
		int lai_huo = head.huo;
		int bu_lai_huo = 0;

		for(int i=0;i<head.nexts.size();i++){
			Node next = head.nexts.get(i);
			ReturnData nextData = process(next);
			lai_huo += nextData.bu_lai_huo;
			bu_lai_huo += Math.max(nextData.lai_huo,nextData.bu_lai_huo);
		}

		return new ReturnData(lai_huo,bu_lai_huo);
	}

	public static int maxHappy(int[][] matrix) {
		int[][] dp = new int[matrix.length][2];
		boolean[] visited = new boolean[matrix.length];
		int root = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (i == matrix[i][0]) {
				root = i;
			}
		}
		process(matrix, dp, visited, root);
		return Math.max(dp[root][0], dp[root][1]);
	}

	public static void process(int[][] matrix, int[][] dp, boolean[] visited, int root) {
		visited[root] = true;
		dp[root][1] = matrix[root][1];
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == root && !visited[i]) {
				process(matrix, dp, visited, i);
				dp[root][1] += dp[i][0];
				dp[root][0] += Math.max(dp[i][1], dp[i][0]);
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 8 }, { 1, 9 }, { 1, 10 } };
		System.out.println(maxHappy(matrix));
	}
}
