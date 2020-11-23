package com.louis.algorithm.剑指offer;
/**
 * 注意点：
 * 1、对传入的数组需要判断是否为空，是否只有一个元素
 * 2、递归的结束条件是start>end
 * 3、处理逻辑：因为是二叉搜索树，所以前面部分应该是小于root的，所以从前往后找小于root的最后一个节点
 *   前面部分是小于left,后面部分应是大于root，如果后面有小于root的则直接返回
 * */
public class 第二十三题二叉搜索树的后序遍历序列 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1 ) {
            return true;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length-1);

    }
    public boolean VerifySquenceOfBST(int [] sequence, int start, int end){
        if (start>end){
            return true;
        }
        int root = sequence[end];
        int i = start;
        for ( ; i<end; i++) {
            if(sequence[i]>root) {
                break;
            }
        }
        int j = i;
        for ( ; j<end; j++) {
            if(sequence[j]<root) {
                return false;
            }
        }
        return VerifySquenceOfBST(sequence,start,i-1) && VerifySquenceOfBST(sequence,i,end-1);
    }

}
