package com.louis.algorithm.Tree;

public class IsBalancedTree {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

    /**
     * 判断是否是平衡二叉树
     * */
    public static boolean isBalanced(Node root){
        if(root==null){
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int diff = left - right;
        if(diff>1||diff<-1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
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


	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		System.out.println(isBalanced(head));

	}

}
