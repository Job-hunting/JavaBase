package com.louis.剑指offer;

import java.util.ArrayList;
import java.util.List;

public class 第三十三题丑数2 {
    public static int GetUglyNumber_Solution(int index) {
        if (index<1) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int cur2 = 0;
        int cur3 = 0;
        int cur5 = 0;
        while(list.size()<index) {
            int num2 = list.get(cur2)*2;
            int num3 = list.get(cur3)*3;
            int num5 = list.get(cur5)*5;
            int min = Math.min(Math.min(num2,num3),num5);
            if (min == num2) {
                cur2++;
            }
            if (min == num3) {
                cur3++;
            }
            if (min == num5) {
                cur5++;
            }
        }
        return list.get(list.size()-1);
    }
    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(1));
    }
}
