package com.louis.algorithm.utils;

import java.util.HashMap;
import java.util.List;
/**
 * 并查集作用：
 * 1、判断两个set是否是同个set:不断往上找代表节点，如果能找到相同的代表节点，则是同一个集合
 * 2、union(setA,setB)：少元素挂在多元素底下
 *适用于查，并很多的情况下，多任务的解题思想
 * */
public class 并查集 {

	public static class Node {
		// whatever you like
	}

	public static class UnionFindSet {
		public HashMap<Node, Node> fatherMap; //child，father
		public HashMap<Node, Integer> sizeMap;//某个节点所在的集合代表节点有多少个节点

		public UnionFindSet(List<Node> nodes) {
			makeSets(nodes);
		}

		private void makeSets(List<Node> nodes) {
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}

		//找代表节点，沿途的所有节点都直接连到代表节点
		private Node findHead(Node node) {
			Node father = fatherMap.get(node);
			if (father != node) {
				father = findHead(father);
			}
			fatherMap.put(node, father);
			return father;
		}
		
		public boolean isSameSet(Node a, Node b) {
			return findHead(a) == findHead(b);
		}

		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aHead = findHead(a);
			Node bHead = findHead(b);
			if (aHead != bHead) {
				int aSetSize= sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);
				if (aSetSize <= bSetSize) {
					fatherMap.put(aHead, bHead);
					sizeMap.put(bHead, aSetSize + bSetSize);
				} else {
					fatherMap.put(bHead, aHead);
					sizeMap.put(aHead, aSetSize + bSetSize);
				}
			}
		}

	}

	public static void main(String[] args) {

	}

}
