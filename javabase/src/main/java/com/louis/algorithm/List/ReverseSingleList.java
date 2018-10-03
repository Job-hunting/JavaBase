package com.louis.algorithm.List;

/**
 * 旋转单向链表
 * */
public class ReverseSingleList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    //从第二个节点开始看
    public static Node reverseList(Node head) {
        Node pre = null;
        while (head != null) {
            Node temp = head.next;   //保存第三个节点
            head.next = pre;   //第二个节点的指针域指向第一个
            pre = head;     //pre指针移动到第2个节点上
            head = temp;    //head移动到第3个节点上
        }
        return pre;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printLinkedList(head1);
        head1 = reverseList(head1);
        printLinkedList(head1);
    }
}
