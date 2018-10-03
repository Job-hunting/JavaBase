package com.louis.剑指offer;
/**
 * 主要考察的是鲁棒性
 * 如果链表为null,或者链表的长度小于k的怎么办
 *
 * */
public class 第十四题链表中倒数第k个结点 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {

        if(head == null) {
            return null;
        }

        ListNode temp = head;
        ListNode p1 = head;
        int count = 0;
        while (temp != null) {
            count ++;
            temp = temp.next;
        }
        if (k>count) {
            return null;
        }

        for (int i =0 ; i<count - k; i++) {
            p1 = p1.next;
        }

        return p1;
    }
}
