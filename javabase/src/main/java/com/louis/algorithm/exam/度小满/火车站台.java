package com.louis.algorithm.exam.度小满;

import java.util.*;

public class 火车站台 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][2];
        for(int i = 0; i< n;i++){
            array[i][0] = scanner.nextInt();
            array[i][1] = scanner.nextInt();
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i= 0;i<n;i++){
            for(int j = array[i][0]; j<array[i][1];j++) {
                if(map.get(j) != null){
                    map.put(j,map.get(j)+1);
                } else {
                    map.put(j,1);
                }
            }
        }
        int  max = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            if(max<m.getValue()){
                max = m.getValue();
            }
        }
        System.out.println(max);
    }
}
