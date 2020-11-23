package com.louis.algorithm.剑指offer;

import java.util.Arrays;
import java.util.Comparator;

public class 第三十二题把数组排成最小的数 {
    public String PrintMinNumber(int [] numbers) {
        String result = "";
        String str[] = new String[numbers.length];
        for (int i =0; i<numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str1.compareTo(str2);
            }
        });
        for (int i = 0; i< str.length; i++) {
            result = result + str[i];
        }

        return result;
    }
}
