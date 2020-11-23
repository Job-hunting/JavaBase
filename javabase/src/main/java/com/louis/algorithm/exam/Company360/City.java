package com.louis.algorithm.exam.Company360;

import java.util.Scanner;

public class City {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int N =  scanner.nextInt();
        long maxA = -100000;
        long minA = 100000;
        long maxB = -100000;
        long minB = 100000;
        for(int i =0 ; i<N; i++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            maxA = Math.max(maxA,a);
            minA = Math.min(minA,a);
            maxB = Math.max(maxB,b);
            minB = Math.min(minB,b);
        }

        long maxC = Math.max((maxA - minA), (maxB - minB));
        System.out.println((int)maxC*maxC);

    }
}
