package com.louis.algorithm.剑指offer;

/**
 * 注意在返回结果时，将result = new ListNode(-1),然后cur = result，对cur遍历，最后返回的是resul.next
 * */
public class 第十六题合并两个排序的链表 {
    public static  class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static  ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null && list2 ==null) {
            return null;
        }
        if (list1 == null && list2 !=null){
            return list2;
        }
        if (list1 != null && list2 == null) {
            return list1;
        }
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        while(list1 != null && list2 != null) {
            if (list1.val<=list2.val){
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1!=null) {
            cur.next = list1;
        }
        if(list2!=null) {
            cur.next = list2;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);

        ListNode res = Merge(head1,head2);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
