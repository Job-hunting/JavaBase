package com.louis.algorithm.other;

import java.util.HashMap;
import java.util.Stack;

public class MaxTree {
    private static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    //返回构造的树的头结点
    public static Node getMaxTree(int[] arr) {
        Node[] nArr = new Node[arr.length];  //生成树的结构,数组中的每一个值都代表一个结点
        for (int i = 0; i < arr.length; i++) {
            nArr[i] = new Node(arr[i]);
        }

        Stack<Node> stack = new Stack<>();
        HashMap<Node, Node> lMap = new HashMap<>();
        HashMap<Node, Node> rMap = new HashMap<>();

        //找每一个数左边离它最近的大的
        for (int i = 0; i < nArr.length; i++) {
            Node cur = nArr[i];
            while (!stack.isEmpty() && stack.peek().value < cur.value) {
                popStackSetValue(stack, lMap);
            }
            stack.push(cur);
        }
        while (!stack.isEmpty()) {
            popStackSetValue(stack, lMap);
        }

        //找每一个数右边比它最近的大的
        for (int i = nArr.length - 1; i >= 0; i--) {
            Node cur = nArr[i];
            while (!stack.isEmpty() && stack.peek().value < cur.value) {
                popStackSetValue(stack, rMap);
            }
            stack.push(cur);
        }
        while (!stack.isEmpty()) {
            popStackSetValue(stack, rMap);
        }

        //开始构造这棵树
        Node head = null;
        for (int i = 0; i < nArr.length; i++) {
            Node cur = nArr[i];
            Node L = lMap.get(cur); //左边离cur最近的
            Node R = rMap.get(cur); //右边离cur最近的

            if (L == null && R == null) {
                head = cur;
            } else if (L == null) {
                if (R.left == null)R.left = cur;
                else R.right = cur;
            } else if (R == null) {
                if (L.left == null)L.left = cur;
                else L.right = cur;
            } else {
                Node minNode = L.value < R.value ? L : R;
                if (minNode.left == null) minNode.left = cur;
                else minNode.right = cur;
            }
        }
        return head;
    }

    //弹出来一个数，并且得到它左/右边边最近的比他大的数
    private static void popStackSetValue(Stack<Node> stack, HashMap<Node, Node> map) {
        Node top = stack.pop();
        if (stack.isEmpty()) {
            map.put(top, null);
        } else {
            map.put(top, stack.peek());
        }
    }

    public static Node getMaxTree2(int[] arr) {
        Node[] nArr = new Node[arr.length];
        for(int i = 0; i < arr.length; i++) nArr[i] = new Node(arr[i]);
        for (int i = 0; i < nArr.length; i++) {
            heapfiyInsert(nArr,i);
        }
        for(int i = 0; i < nArr.length; i++){
            if(2 * i + 1 < nArr.length){
                nArr[i].left = nArr[2*i + 1];
            }
            if(2 * i + 2 < nArr.length){
                nArr[i].right = nArr[2*i + 2];
            }
        }
        return nArr[0];
    }

    public static void heapfiyInsert(Node[] nArr, int index) {
        while (nArr[index].value > nArr[(index - 1) / 2].value) {
            swap(nArr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }


    public static void swap(Node[] nArr,int a,int b){
        Node temp = nArr[a];
        nArr[a] = nArr[b];
        nArr[b] = temp;
    }


    public static void printTree(Node head,int height,String to,int len){
        if(head == null)return;
        printTree(head.right,height + 1,"v",len);

        String val = to + head.value + to;  //两边指示的字符
        int lenV = val.length();
        int lenL = (len - lenV)/2;   //左边的空格(分一半)
        int lenR = len - lenV - lenL;  // 右边的空格
        System.out.println( getSpace(len * height) + getSpace(lenL) + val + getSpace(lenR));

        printTree(head.left,height + 1,"^",len);
    }
    //获取指定的空格
    public static String getSpace(int len){
        StringBuffer str = new StringBuffer();
        for(int i = 0; i < len; i++) str.append(" ");
        return str.toString();
    }

    //测试
    public static void main(String[] args) {
        int[] uniqueArr = {3,4,5,1,2};
        Node head = getMaxTree(uniqueArr);
        printTree(head,0,"H",10);


        System.out.println("-----------------");
        head = getMaxTree2(uniqueArr);
        printTree(head,0,"H",10);
    }
}
