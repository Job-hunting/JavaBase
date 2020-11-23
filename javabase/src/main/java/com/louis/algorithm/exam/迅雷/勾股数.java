package com.louis.algorithm.exam.迅雷;

import java.util.Scanner;

public class 勾股数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int i,j,k;
        int count = 0;
        for(i = 1; i <= N; i++){
            for(j = i + 1;(j*j)+(i*i)<= N*N; j++){
                for(k = j + 1; k <= N; k++){
                    if((i*i + j*j) == k*k && check(i,j) && check(j,k)){
                        ++count;
                    }
                    else if((i*i + j*j)< k*k){
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }


    public static boolean check(int m,int n){
        if(m==1||n==1){
            return true;
        }
        while(true){
            int t = m%n;
            if(t == 0) break;
            else{
                m = n;
                n = t;
            }
        }
        if(n>1)	return false;
        else return true;
    }
}
