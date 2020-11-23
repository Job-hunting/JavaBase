package com.louis.algorithm.letcode.二叉树;

import java.util.Stack;

/**
 * @author duansaisai
 * @date 2020-10-18 10:31
 */
public class 二叉树非递归遍历 {
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

    public static Stack<TreeNode> stack = new Stack<>();

    public static void pre(TreeNode root) {
        stack.push(root);
        TreeNode node = root;
        while (!stack.isEmpty()) {
            if (node != null) {
                System.out.print(node.val);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    public static void mid(TreeNode root) {
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.val);
                node = node.right;
            }
        }
    }


    /**
     * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/er-cha-shu-qian-xu-zhong-xu-hou-xu-ceng-xu-bian-2/
     * */
    public static void post(TreeNode root) {
        TreeNode node = root;
        TreeNode pre = null;
        while(node !=null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null || node.right == pre) {
                System.out.print(node.val);
                pre = node;
                stack.pop();
                node = null;
            } else {
                node = node.right;
            }
        }

    }

    public static void main(String[] args) {
        TreeNode root = init();
        System.out.println("pre:");

        System.out.println("");
        System.out.println("mid:");
        mid(root);

        System.out.println("");
        System.out.println("post:");
        post(root);
    }


}
