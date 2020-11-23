package com.louis.algorithm.exam.搜狐;

import java.util.*;

public class 兄弟串 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        String A = scanner.next();
        String B = scanner.next();
        if(compare(A,B)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static boolean compare(String A, String B) {
        if (A.length() != B.length())
            return false;
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();
        if (A.equals(B)){
            int [] count = new int[26];
            for ( char chars : charsA){
                count[chars - 'a'] ++;
            }
            for (int c : count) {
                if (c > 1) {
                    return true;
                }
            }
            return false;
        }else {
            int first = 0;
            int second = 0;
            for (int i = 0; i < charsA.length; i++){
                if (charsA[i] != charsB[i]){
                    if (first == 0){
                        first = i;
                    }else if (second == 0){
                        second = i;
                    }else {
                        return false;
                    }
                }
            }
            if (charsA[first] != charsB[second] || charsA[second] != charsB[first])
                return false;
        }
        return true;
    }


}
