package com.louis.algorithm.exam.Xiecheng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Dingdan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int N = Integer.parseInt(sc.nextLine());
            int A = Integer.parseInt(sc.nextLine());
            ArrayList<Integer> list = new ArrayList<>();
            for (int i=0; i<N; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                if (A >= b && A <= c) {
                    list.add(a);
                }
            }
            if(list.size() == 0) {
                System.out.println("null");
                continue;
            }
            Collections.sort(list);
            for (Integer l:list) {
                System.out.println(l);
            }
        }


    }
}
