package com.louis.algorithm.exam.小红书;

import java.util.Scanner;

public class 不同形态树 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();
        String[] strings1 = string1.split(" ");
        String[] strings2 = string2.split(" ");
        int[] array1 = new int[strings1.length];
        int[] array2 = new int[strings2.length];
        for (int i = 0 ;i<strings1.length;i++) {
            array1[i] = Integer.parseInt(strings1[i]);
        }
        for (int i = 0 ;i<strings2.length;i++) {
            array2[i] = Integer.parseInt(strings2[i]);
        }

        BinaryTree biTree=new BinaryTree();

        biTree.initTree(array1, array2);

    }

}

class Node{
    public int data;
    public Node left;
    public Node right;
    public Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}


class BinaryTree{
    private Node root;
    public BinaryTree(){
        root=null;
    }

    public void postOrder2(Node localRoot){
        if(localRoot!=null){
            postOrder2(localRoot.left);
            postOrder2(localRoot.right);
            System.out.print(localRoot.data+" ");
        }
    }
    public void postOrder2(){
        this.postOrder2(this.root);
    }

    public void initTree(int[] pre,int[] in){
        this.root=this.initTree(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    public Node initTree(int[] pre,int start1,int end1,int[] in,int start2,int end2){
        if(start1>end1 ||start2>end2){
            return null;
        }
        int rootData=pre[start1];
        Node head=new Node(rootData);
        int rootIndex=findIndexInArray(in,rootData,start2,end2);
        int offSet=rootIndex-start2-1;
        Node left=initTree(pre, start1+1, start1+1+offSet, in, start2, start2+offSet);
        Node right=initTree(pre, start1+1+offSet+1, end1, in, rootIndex+1, end2);
        head.left=left;
        head.right=right;
        return head;
    }

    public int findIndexInArray(int[] a,int x,int begin,int end){
        for(int i=begin;i<=end;i++){
            if(a[i]==x){
                return i;
            }
        }
        return -1;
    }
}
