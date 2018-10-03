package com.louis.algorithm.Tree;

import java.util.HashMap;
import java.util.Map;

public class TrieTreeHashMap {
    private TrieNode root;
    private int count;//词频数
    public TrieTreeHashMap() {
        root = new TrieNode();
        root.wordEnd = false;
    }
    public void insert(String word){
        TrieNode node=root;
        for (int i=0;i<word.length();i++){
            Character c=word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c,new TrieNode());
            }
            node=node.children.get(c);
        }
        node.wordEnd=true;
        node.count++;
    }
    public boolean search(String word){
        TrieNode node=root;
        boolean found=true;
        for(int i=0;i<word.length();i++){
            Character c=word.charAt(i);
            if (!node.children.containsKey(c)){
                return false;
            }
            node=node.children.get(c);
        }
        return found&&node.wordEnd;
    }
    public int getCount(String str){
        TrieNode node=root;
        int count=0;
        for(int i=0;i<str.length();i++){
            Character c=str.charAt(i);
            if (!node.children.containsKey(c)){
                return count;
            }
            node=node.children.get(c);
            if (i==str.length()-1){
                count=node.count;
            }
        }
        return count;
    }
    public class TrieNode {
        Map<Character, TrieNode> children;
        boolean wordEnd;
        public int count;
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            wordEnd = false;
            count=0;
        }
    }
    public static void main(String[] args){
        TrieTreeHashMap trie=new  TrieTreeHashMap();
        trie.insert("abcd");
        trie.insert("abcd");
        trie.insert("abcd");
        trie.insert("abcd");
        trie.insert("abcd");
        trie.insert("abd");
        trie.insert("bcd");
        trie.insert("efg");
        trie.insert("abc");
        trie.insert("abc");
        trie.insert("efg");
   //     boolean flag=trie.search("h");

   //     if (flag){
   //         System.out.println("存在！");
   //     }else {
   //         System.out.println("不存在！");
   //     }

        System.out.println("count:"+trie.getCount("abcd"));
    }
}
