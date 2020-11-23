package com.louis.algorithm.exam.腾讯;

import java.util.Arrays;
import java.util.Scanner;

public class 最小公倍数2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        int n=scanner.nextInt();
        int max = 1000000+1;
        Boolean[] booleans = new Boolean[max];
        int res=2;
        Arrays.fill(booleans,false);
        primes(booleans);

        for (int i=2;i<=n;i++){
            if (!booleans[i]){
                int sum=i;
                while (sum<=n/i){
                    sum = sum*i;
                }
                res = Math.max(res,(n/sum+1)*sum);
            }
        }
        System.out.println(res);
    }
    public static void primes(Boolean[] prime){
        int max = 1000000+1;
        prime[0] = prime[1] = true;
        for (int i=2; i<max;i++){
            if (!prime[i]){
                if (i > max/i)continue;
                for (int j=i*i; j<max;j+=i){
                    prime[j]=true;
                }
            }
        }
    }

}
