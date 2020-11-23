package com.louis.algorithm.exam.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class grap {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        int result = 0;
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++) {
            arr[i] = sc.nextInt();
        }

        int l= 0;
        int r=0;
        for(int i=0; i<arr.length;i++){
            l = i;
            r = k+l-1;
            if(r>=arr.length){
                break;
            }
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j = l; j<=r;j++){
                int temp = arr[j];
                if(map.get(temp) == null){
                    map.put(temp,1);
                } else {
                    map.put(temp,map.get(temp)+1);
                }
            }

            for(Map.Entry<Integer,Integer> m : map.entrySet()) {
                if(m.getValue()>=t){
                    result = result +1;
                }
            }
        }
        System.out.println(result);
    }
}
