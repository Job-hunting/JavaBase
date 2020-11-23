package com.louis.algorithm.exam.搜狐;

import java.util.Scanner;

public class 比较坂本号 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        String A = scanner.next();
        String B = scanner.next();
        System.out.println(compare(A,B));
    }

    public static int compare(String A, String B) {

        String[] arr1 = A.split(".");
        String[] arr2 = B.split(".");

        int length = Math.max(arr1.length, arr2.length);

        for(int i = 0; i < length; i++) {
            Integer a1 = i < arr1.length ? Integer.parseInt(arr1[i]) : 0;
            Integer a2 = i < arr2.length ? Integer.parseInt(arr2[i]) : 0;

            if ( a1 < a2 ) {
                return -1;
            } else if ( a1 > a2 ) {
                return 1;
            }
        }
        return 0;
    }

}
