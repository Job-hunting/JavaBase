package com.louis.algorithm.剑指offer;



import java.util.*;
/**
 *
 * 使用hashmap，第一次遍历链表，创建节点
 * 后面需要两次遍历，分别处理next，random指针指向
 * */
public class 第二十五题复杂链表的复制 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode head = new RandomListNode(-1);
        RandomListNode cur = pHead;
        Map<RandomListNode, RandomListNode> nextMap = new HashMap<>();
        while(cur!=null) {
            nextMap.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur =pHead;
        while (cur != null) {
            nextMap.get(cur).next = nextMap.get(cur.next);
            cur = cur.next;
        }
        cur =pHead;
        RandomListNode res = nextMap.get(cur);
        while (cur != null) {
            nextMap.get(cur).random = nextMap.get(cur.random);
            cur = cur.next;
        }
        return res;

    }
}
