package com.louis.algorithm.Tree;

import sun.management.snmp.util.SnmpTableCache;

import java.util.LinkedList;
import java.util.Stack;
/**
 *
 * 树的前序遍历，中序遍历，后序遍历递归实现和非递归实现
 * https://blog.csdn.net/jssongwei/article/details/50790253
 * */
public class PreInPosTraversal {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value + " ");
		inOrderRecur(head.right);
	}

	public static void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value + " ");
	}


	/**
	 * 前序遍历
	 * 1、打印当前阶段
	 * 2、往左孩子遍历，加入到stack中
	 * 3、当左孩子未null时，弹出node,另node=node.right
	 * */
	public static void preOrder_stack(Node root){//先序遍历

		Stack<Node> stack = new Stack<Node>();
		Node node = root;

		while(node != null || stack.size()>0){//将所有左孩子压栈
			if(node != null){//压栈之前先访问
				printNode(node);
				stack.push(node);
				node = node.left;

			}else{
				node = stack.pop();
				node = node.right;
			}
		}
	}

	/**
	 * 中序遍历
	 * 1、当前节点压栈
	 * 2、往左遍历，压栈
	 * 3、当前节点是空时，从栈弹出，打印，找右节点
	 * */
	public static void inOrder_Stack(Node root){//中序遍历

		Stack<Node> stack = new Stack<Node>();
		Node node = root;

		while(node != null || stack.size()>0){
			if(node != null){
				stack.push(node);//直接压栈
				node = node.left;
			}else{
				node = stack.pop();//出栈并访问
				printNode(node);
				node = node.right;
			}
		}
	}


	/**
	 * 后续遍历
	 * 1、如果当前节点不是空，加入到stack和output中
	 * 2、往右节点找
	 * 3、如果当前节点是空，则从栈弹出一个节点，找到它的左节点
	 * 4、最后对output栈全部弹出打印
	 * */
	public static void postOrder_Stack(Node root){//后续遍历

		Stack<Node> stack = new Stack<Node>();
		Stack<Node> output = new Stack<Node>();//构造一个中间栈来存储逆后续遍历的结果
		Node node = root;
		while(node != null || stack.size()>0){
			if(node != null){
				output.push(node);
				stack.push(node);
				node = node.right;
			}else{
				node = stack.pop();
				node = node.left;
			}
		}

		while(output.size()>0){
			printNode(output.pop());
		}

	}


	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);

		// recursive
		System.out.println("==============recursive==============");
		System.out.print("pre-order: ");
		preOrderRecur(head);
		System.out.println();
		System.out.print("in-order: ");
		inOrderRecur(head);
		System.out.println();
		System.out.print("pos-order: ");
		posOrderRecur(head);
		System.out.println();

		// unrecursive
		System.out.println("============unrecursive=============");
		preOrder_stack(head);
		System.out.println();
		inOrder_Stack(head);
		System.out.println();
		postOrder_Stack(head);

		System.out.println("============层序遍历=============");
		levelOrder(head);

	}

	public static void printNode(Node node){
		System.out.print(node.value + " ");
	}


	/**
	 * 递归求树的深度
	 * */
	public static int treeDepth(Node root){
		if(root == null){
			return 0;
		}
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);

		return (left>right)?(left+1):(right+1);
	}


    /**
	 * 判断是否是平衡二叉树
	 * */
	public static boolean isBalanced_1(Node root){
		if(root==null){
			return true;
		}
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		int diff = left - right;
		if(diff>1||diff<-1){
			return false;
		}
		return isBalanced_1(root.left)&&isBalanced_1(root.right);
	}

	/**
	 * 层序遍历
	 * */
	public static void levelOrder(Node root){
		if(root == null) {
			return;
		}
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node node  = queue.poll();
			printNode(node);
			if(node.left!=null){
				queue.offer(node.left);
			}
			if(node.right!=null){
				queue.offer(node.right);
			}
		}
	}
}
