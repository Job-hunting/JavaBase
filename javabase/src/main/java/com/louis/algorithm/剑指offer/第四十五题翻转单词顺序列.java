package com.louis.algorithm.剑指offer;

public class 第四十五题翻转单词顺序列 {
    public String ReverseSentence(String str) {
        if(str == null || str.length()==0) {
            return "";
        }
        if(str.trim().equals("")){
            return str;
        }
        String[] s= str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s.length-1;i>=0;i--){
            sb.append(s[i]);
            if(i!=0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
