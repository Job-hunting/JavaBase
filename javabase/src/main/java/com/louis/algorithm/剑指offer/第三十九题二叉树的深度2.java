package com.louis.algorithm.剑指offer;

import java.util.LinkedList;

/***
 *
 * 非递归实现层序遍历
 *
 * 1、求深度：确保width遍历完，然后才对depth+1
 * 2、求最大宽度
 * 3、求第d层，第n个节点
 * */
public class 第三十九题二叉树的深度2 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public int TreeDepth(TreeNode root) {
        int d = 0;
        int n = 0;
        TreeNode result;
        if(root == null) {
            return  0 ;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        int depth = 0;
        int width = 0;
        int maxWidth = Integer.MIN_VALUE;
        while(queue.size()>0) {
            int  cur =  0;
            width = queue.size();
            maxWidth = Math.max(maxWidth,width);
            while(cur<width) {
                TreeNode top = queue.poll();
                if(depth+1==d &&cur+1==n)					//找到符合条件的节点
                    result = top;

                if(top.left != null){
                    queue.add(top.left);
                }
                if(top.right != null) {
                    queue.add(top.right);
                }
                cur++;
            }
           depth++;
        }
        return depth;
    }

}
