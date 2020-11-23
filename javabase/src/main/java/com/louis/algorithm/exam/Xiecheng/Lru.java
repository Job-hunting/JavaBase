package com.louis.algorithm.exam.Xiecheng;

import java.util.HashMap;
import java.util.Scanner;

public class Lru {
    public static class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    public static class LRU {
        int capacity;
        HashMap<Integer,Node> map=new HashMap<>();
        Node head=null;
        Node tail=null;
        public LRU(int capacity) {
            this.capacity = capacity;
        }
        public int get(int key){
            if(map.containsKey(key)){
                Node node=map.get(key);
                remove(node);
                setHead(node);
                return node.value;
            }
            return -1;
        }
        public void remove(Node n){
            if(n.pre!=null){
                n.pre.next = n.next;
            }else{
                head = n.next;
            }
            if(n.next!=null){
                n.next.pre = n.pre;
            }else{
                tail = n.pre;
            }
        }
        public void setHead(Node n){
            n.next = head;
            n.pre = null;
            if(head!=null)
                head.pre = n;
            head = n;

            if(tail ==null)
                tail = head;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node old = map.get(key);
                old.value = value;
            } else {
                Node created = new Node(key, value);
                if (map.size() >= capacity) {
                    map.remove(tail.key);
                    remove(tail);
                    setHead(created);
                } else {
                    setHead(created);
                }
                map.put(key, created);
            }
        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N =Integer.parseInt(sc.nextLine());
        LRU lruCache=new LRU(N);
        while (sc.hasNext()){
            String str=sc.nextLine().trim();
            String[] strs=str.split(" ");
            if (strs.length==3){
                if (strs[0].equals("p")){
                    lruCache.put(Integer.parseInt(strs[1]),Integer.parseInt(strs[2]));
                }
            }
            if (strs.length==2){
                if (strs[0].equals("g")){
                    int res=lruCache.get(Integer.parseInt(strs[1]));
                    System.out.println(res);
                }
            }
        }
    }
}
