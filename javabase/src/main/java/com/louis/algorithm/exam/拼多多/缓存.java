package com.louis.algorithm.exam.拼多多;


import java.util.HashMap;
import java.util.Scanner;

public class 缓存 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i <n ; i++) {
            array[i] = scanner.nextInt();
        }
        int[] change = new int[n+1];
        int times =n;
        if(times >= 100)
            times = n/4;
        for (int i = 1; i <=times ; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j <n; j++) {
                if(map.containsKey(array[j]%i) &&  map.get(array[j]%i) == array[j]) {
                    change[i]++;
                }
                else{
                    map.put(array[j]%i, array[j]);
                }
            }

        }
        int max =Integer.MIN_VALUE;
        for (int i = 1; i <=n ; i++) {
            if(max < change[i]){
                max = change[i];
            }
        }
        for (int i = 1; i <=n ; i++) {
            if(change[i] == max){
                System.out.println(i);
                break;
            }
        }
    }

}
