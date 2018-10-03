package com.louis.剑指offer;
/**
 *
 * 左子树的最右节点 <=====> root  <=====> 右子树的最左节点
 * 最后返回结果是如果有left返回left,如果没有，则返回root
 * */
public class 第二十六题二叉搜索树与双向链表 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right ==null) {
            return pRootOfTree;
        }


        TreeNode left =  Convert(pRootOfTree.left);  //左子树
        TreeNode p = left;
        while(p != null && p.right != null) {
            p = p.right;
        }
        if (left != null) {
            p.right = pRootOfTree ;
            pRootOfTree.left = p;
        }

        TreeNode right = Convert(pRootOfTree.right);    //右子树
        TreeNode q = right;
        while(q !=null && q.left !=null) {
            q = q.left;
        }
        if (right != null) {
            q.left = pRootOfTree;
            pRootOfTree.right = q;
        }
        return left != null?left:pRootOfTree;
    }
}
