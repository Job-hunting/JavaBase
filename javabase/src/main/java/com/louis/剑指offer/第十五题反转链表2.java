package com.louis.剑指offer;
/**
 * 使用头插法
 * */
public class 第十五题反转链表2 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head){
        if (head == null || head.next ==null) {
            return head;
        }
        ListNode result = null;
        while(head!=null) {
            ListNode temp = head.next;
            head.next = result;
            result = head;
            head = temp;
        }
        return result;
    }
}
