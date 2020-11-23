package com.louis.algorithm.exam.顺丰科技;

import java.util.*;

public class 双节棍字符串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(getLongString(string));
    }

    public static String getLongString(String string) {
        if (string == null || string.length()<3) {
            return null;
        }
        String result = "";
        int maxLength = 0;
        char[] chars = string.toCharArray();

        for (int i = 0; i < chars.length;){
            int cur = i+1;
            while(chars[cur] == chars[cur-1]){
                cur++;
            }
            int curB = cur;
            while(chars[curB+1] == chars[curB]) {
                curB++;
            }
            if(curB == chars.length){
                continue;
            }
            int curC = curB+1;
            int count =0;
            int t = curC;
            for (; chars[t] == chars[curC];t++) {
                count++;
            }
            if (count == curB-i) {
               if(count>maxLength) {
                   maxLength = count;
                   StringBuilder sb = new StringBuilder();
                   for(int w = i; w<2*count+curC-curB;w++) {
                       sb.append(chars[i]);
                   }
                   result = sb.toString();
               } else {
                   i = curB;
               }
            } else {
                i = curB;
            }
        }
        if(maxLength == 0) {
            return null;
        }

        return result;
    }
}
