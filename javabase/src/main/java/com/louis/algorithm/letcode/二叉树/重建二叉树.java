package com.louis.algorithm.letcode.二叉树;

/**
 * @author duansaisai
 * @date 2020-10-12 21:03
 */
public class 重建二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       TreeNode treeNode = buildTree(preorder, 0, inorder.length - 1, inorder, 0, inorder.length - 1);
       return treeNode;

    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return  null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                root.left = buildTree(preorder, preStart + 1, preStart + (i - inStart), inorder, inStart, i - 1);
                root.right = buildTree(preorder, preStart + (i - inStart) + 1, preEnd, inorder, i + 1, inEnd);
                break;
            }

        }
        return root;

    }
}
