package com.louis.algorithm.剑指offer;

public class 第四十四题左旋转字符串 {
    public String LeftRotateString(String str,int n) {
        if(str==null|| str.length()<n){
            return "";
        }
        char[] c = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = n; i<c.length;i++){
            sb.append(c[i]+"");
        }
        for(int i=0;i<n;i++) {
            sb.append(c[i]+"");
        }
        return sb.toString();
    }


}
