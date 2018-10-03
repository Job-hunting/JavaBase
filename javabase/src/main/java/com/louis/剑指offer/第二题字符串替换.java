package com.louis.剑指offer;

public class 第二题字符串替换 {
    public static void main(String[] args) {
        StringBuffer stringBuffer =  new StringBuffer("hello world");
        replaceSpace(stringBuffer);
    }
    public static String replaceSpace(StringBuffer str) {
        char[] c = str.toString().toCharArray();
        int count = 0;
        for (int i=0; i<c.length;i++){
            if(c[i] == ' '){
                count++;
            }
        }
        char[] r = new char[c.length+2*count];
        int index =  c.length+2*count -1;
        for (int i=c.length-1; i>=0; i--){
            if(c[i] != ' '){
                r[index] = c[i];
                index = index-1;
            } else if(c[i] == ' ') {
                r[index] = '0';
                index = index-1;
                r[index] = '2';
                index = index-1;
                r[index] = '%';

            }
        }
        return String.valueOf(r);
    }
}
