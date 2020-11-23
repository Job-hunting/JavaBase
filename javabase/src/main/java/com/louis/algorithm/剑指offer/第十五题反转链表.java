package com.louis.algorithm.剑指offer;

import java.util.Stack;
/**
 * 用栈实现
 * */
public class 第十五题反转链表 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ListNode ReverseList(ListNode head) {
            if (head == null || head.next == null){
                return head;
            }
            ListNode p = head;
            ListNode newHead;
            Stack<ListNode> stack = new Stack<>();
            while(p.next != null) {
                stack.push(p);
                p = p.next;
            }

            newHead = p;
            while(!stack.isEmpty()){
                p.next = stack.pop();
                p = p.next;
            }
            p.next = null;
            return newHead;
        }
    }
}
