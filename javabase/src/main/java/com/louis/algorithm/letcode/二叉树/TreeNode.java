package com.louis.algorithm.letcode.二叉树;

/**
 * @author duansaisai
 * @date 2020-10-18 10:06
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
