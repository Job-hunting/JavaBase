package exam.小红书;

import java.util.Scanner;

public class PostOreder__PreAndIN {

    public static void main(String[] args) {
        BinaryTree2 biTree=new BinaryTree2();
//        int[] pre={8,4,9,2,10,5,1,6,3,7};
//        int[] in={8,4,9,2,10,5,1,6,3,7};
//3 5 4 2 6 7 1
//2 5 3 6 4 7 1
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();
        String[] str1 = string1.split(" ");
        String[] str2 = string2.split(" ");
        int[] array1 = new int[str1.length];
        int[] array2 = new int[str2.length];
        for (int i = 0 ;i<str1.length;i++) {
            array1[i] = Integer.parseInt(str1[i]);
        }
        for (int i = 0 ;i<str2.length;i++) {
            array2[i] = Integer.parseInt(str2[i]);
        }

        biTree.initTree(array1, array2);
        System.out.println("二叉树的后序遍历：");
        biTree.postOrder2();
    }

}
//定义节点的数据结构
class Node2{
    public int data;
    public Node2 left;
    public Node2 right;
    public Node2(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

//定义一个二叉树
class BinaryTree2{
    private Node2 root;
    public BinaryTree2(){
        root=null;
    }
    //后序遍历方法递归实现
    public void postOrder2(Node2 localRoot){
        if(localRoot!=null){
            postOrder2(localRoot.left);
            postOrder2(localRoot.right);
            System.out.print(localRoot.data+" ");
        }
    }
    public void postOrder2(){
        this.postOrder2(this.root);
    }

    //初始化二叉树
    public void initTree(int[] pre,int[] in){
        this.root=this.initTree(pre, 0, pre.length-1, in, 0, in.length-1);
    }
    public Node2 initTree(int[] pre,int start1,int end1,int[] in,int start2,int end2){
        if(start1>end1 ||start2>end2){
            return null;
        }
        int rootData=pre[start1];
        Node2 head=new Node2(rootData);
        //找到根节点所在的位置
        int rootIndex=findIndexInArray(in,rootData,start2,end2);
        int offSet=rootIndex-start2-1;
        //构建左子树
        Node2 left=initTree(pre, start1+1, start1+1+offSet, in, start2, start2+offSet);
        //构建右子树
        Node2 right=initTree(pre, start1+1+offSet+1, end1, in, rootIndex+1, end2);
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