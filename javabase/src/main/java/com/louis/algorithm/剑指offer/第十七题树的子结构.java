package com.louis.algorithm.剑指offer;

public class 第十七题树的子结构 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 !=null) {
            if (root1.val == root2.val) {        //如果遇到根节点值是相同的，则比对孩子节点
                result = compare(root1,root2);
            }
            if (!result) {                   //如果比对返回值是false，则找root1的下一个节点与root2进行比对
                result =  HasSubtree(root1.left,root2);
            }
            if (!result) {
                result =  HasSubtree(root1.right,root2);
            }
        }
        return result;
    }

    public boolean compare(TreeNode root1,TreeNode root2){
        if (root2 == null) {     //root2节点走完了，则说明是完全匹配的
            return true;
        }
        if (root1 == null){     //在前一个判断的基础上，root1走完了，则说明没有匹配到
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return compare(root1.left,root2.left) && compare(root1.right,root2.right);
    }
}
