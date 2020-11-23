package com.louis.algorithm.剑指offer;

import java.util.ArrayList;
/**
 *
 * ArrayList可以作为队列，remove(0);
 * */
public class 第二十二从上往下打印二叉树 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result =  new ArrayList<>();
        ArrayList<TreeNode> queue  = new ArrayList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);

        while(queue.size() != 0) {
            TreeNode node = queue.remove(0);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            result.add(node.val);
        }
        return result;
    }
}
