package com.louis.algorithm.letcode;

import java.util.Stack;

/**
 * @author duansaisai
 * @date 2020-10-11 23:05
 */
public class 从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        int count = 0;
        Stack<ListNode> stack = new Stack<>();
        while (head!= null) {
            stack.push(head);
            head = head.next;
            count++;
        }
        int[] ints = new int[count];

        int i = 0;
        while (!stack.isEmpty()) {
            ints[i++] = stack.pop().val;
        }
        return ints;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}