package com.louis.algorithm.剑指offer;

import java.util.HashMap;
import java.util.Map;

public class 第三十五题第一个只出现一次的字符 {
    public int FirstNotRepeatingChar(String str) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i<str.length(); i++) {
            if(map.get(str.charAt(i)) == null) {
                map.put(str.charAt(i),1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
        }
        for (int i = 0; i<str.length(); i++) {
            if(map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
