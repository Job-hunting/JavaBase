package com.louis.algorithm.letcode.二叉树;

/**
 * @author duansaisai
 * @date 2020-10-18 10:06
 */
public class 二叉树递归遍历 {

    /**
     *           6
     *       3       9
     *    1    5   7
     *      2 4       8
     * */
    public static TreeNode init() {
        TreeNode J = new TreeNode(8, null, null);
        TreeNode H = new TreeNode(4, null, null);
        TreeNode G = new TreeNode(2, null, null);
        TreeNode F = new TreeNode(7, null, J);
        TreeNode E = new TreeNode(5, H, null);
        TreeNode D = new TreeNode(1, null, G);
        TreeNode C = new TreeNode(9, F, null);
        TreeNode B = new TreeNode(3, D, E);
        TreeNode A = new TreeNode(6, B, C);
        return A;
    }

    public static void pre(TreeNode root) {
        System.out.print(root.val);
        if (root.left != null) {
            pre(root.left);
        }
        if (root.right != null) {
            pre(root.right);
        }
    }

    public static void post(TreeNode root) {
        if (root.left != null) {
            post(root.left);
        }
        if (root.right != null) {
            post(root.right);
        }
        System.out.print(root.val);
    }

    public static void mid(TreeNode root) {
        if (root.left != null) {
            mid(root.left);
        }
        System.out.print(root.val);
        if (root.right != null) {
            mid(root.right);
        }
    }


    public static void main(String[] args) {
        TreeNode root = init();
        System.out.println("pre:");
        pre(root);

        System.out.println("");
        System.out.println("mid:");
        mid(root);

        System.out.println("");
        System.out.println("post:");
        post(root);
    }

}

