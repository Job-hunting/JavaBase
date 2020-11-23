package com.louis.algorithm.letcode;

/**
 * @author duansaisai
 * @date 2020-11-06 19:58
 */
public class 删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        ListNode pre = head;
        while(cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
