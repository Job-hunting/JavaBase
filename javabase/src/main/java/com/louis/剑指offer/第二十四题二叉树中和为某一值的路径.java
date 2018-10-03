package com.louis.剑指offer;

import java.util.ArrayList;
/**
 *
 * 注意点:
 * 1、当root为空时，不应该返回null，应该返回result
 * 2、两个list都是放到函数外面的，作为全局变量，遍历回溯都是对list操作的
 * 3、结合着前序遍历的递归思想
 * */
public class 第二十四题二叉树中和为某一值的路径 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return result;
        }

        target = target - root.val;
        list.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {     //如果最后target是0了，并且是叶子节点，则加入到result中
            result.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left,target);   //继续找孩子，但是孩子是null,直接返回
        FindPath(root.right,target);
        list.remove(list.size()-1);  //回到
        return result;
    }

}
