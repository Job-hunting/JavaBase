package com.louis.剑指offer;

public class 第四题重建二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode treeNode = construct(pre, 0, pre.length-1,in,0,in.length-1);
        return treeNode;
    }

    public TreeNode construct(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
        if(preStart>preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        for (int i = inStart; i<=inEnd; i++) {
            if (in[i] == pre[preStart]) {
                root.left = construct(pre, preStart+1, preStart+(i-inStart), in, inStart, i-1);
                root.right = construct(pre, preStart+(i-inStart)+1, preEnd, in, i+1, inEnd);
                break;
            }
        }
        return root;
    }
}
