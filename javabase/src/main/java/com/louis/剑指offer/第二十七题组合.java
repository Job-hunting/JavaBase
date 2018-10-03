package com.louis.剑指offer;

import java.util.ArrayList;
import java.util.List;

public class 第二十七题组合 {

    public static void main(String[] args) {
        char[] chs = {'a','b','c'};
        comb(chs);
    }

    public static void comb(char[] chs) {
        int len = chs.length;
        int nbits = 1 << len;
        for (int i = 0; i < nbits; ++i) {
            int t;
            for (int j = 0; j < len; j++) {
                t = 1 << j;
                if ((t & i) != 0) { // 与运算，同为1时才会是1
                    System.out.print(chs[j]);
                }
            }
            System.out.println();
        }
    }

}
