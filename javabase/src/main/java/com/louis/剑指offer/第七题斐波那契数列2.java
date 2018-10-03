package com.louis.剑指offer;
/**
 * 求n，0开始累加，直到累加到n
 *
 * */
public class 第七题斐波那契数列2 {
    public int Fibonacci(int n) {
        int result =0 ;
        if(n<2){
            return n;
        }
        int min =0;
        int max =1;
        for(int i = 2; i<=n;i++){
            int temp = max;
            max = min + max;
            min = temp;
        }
        return max;
    }
}
