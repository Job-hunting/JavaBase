package com.louis.algorithm.剑指offer;

/**
 *
 * 错误点:在计算链表长度时，pHead1是不停的往后移动，所以在减去长度后，此时的phead1指向的不再是头节点了
 *
 * */

public class 第三十七题两个链表的第一个公共节点 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        if(pHead1 == null || pHead2 == null) {
            return null;
        }
        int len1 = 0;
        int len2 = 0;
        while(pHead1 != null) {
            len1++;
            pHead1 = pHead1.next;
        }
        while(pHead2 != null) {
            len2++;
            pHead2 = pHead2.next;
        }
        int temp = len1 -len2;
        if(temp>0){
            for (int i=0; i<temp; i++){
                cur1 = cur1.next;
            }
        } else {
            for (int i=0; i<Math.abs(temp); i++){
                cur2 = cur2.next;
            }
        }
        while(cur1!=null && cur2!=null){
            if(cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;

    }
}
