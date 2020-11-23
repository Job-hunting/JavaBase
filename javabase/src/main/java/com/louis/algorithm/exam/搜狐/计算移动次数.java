package com.louis.algorithm.exam.搜狐;

import java.util.Scanner;

public class 计算移动次数 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int N = scanner.nextInt();
        int k =0,s=0;
        while(s<Math.abs(N)){
            k = k+1;
            s = s+k;
        }
        if ((s-Math.abs(N))%2 == 0) {
            System.out.println(k);
        } else {
            if (k%2 ==0) {
                System.out.println(k+1);
            }
            else{
                System.out.println(k+2);
            }
        }
    }
}
