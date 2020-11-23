package com.louis.algorithm.剑指offer;

import java.util.ArrayList;
import java.util.Stack;
/**
 *
 * 使用栈
 * */
public class 第三题从尾到头打印链表 {
    public class ListNode {
        int val;
       ListNode next = null;
       ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();
        while(listNode != null){
            stack.push(listNode);
            listNode = listNode.next;
        }
        while(stack.size() != 0) {
            list.add(stack.pop().val);
        }
        return list;
    }
}
