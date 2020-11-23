package com.louis.algorithm.exam.拼多多;

import java.util.*;

public class 查频率最大的若干单词 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String str = scanner.nextLine();
        List<String> list =  most(str);
        for (int i = 0; i< list.size();i++) {
            System.out.print(list.get(i) + " ");
        }

    }

    public static List<String> most(String str) {
        String result = null;
        List<String> list =  new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        StringTokenizer stringTokenizer = new StringTokenizer(str.toLowerCase(), " |!|\\?|'|,|;|\\.|:|-");
        while (stringTokenizer.hasMoreTokens()) {
            String temp = stringTokenizer.nextToken();
            if(!map.containsKey(temp)) {
                map.put(temp, 1);
            }else {
                Integer count = map.get(temp);
                map.remove(temp);
                map.put(temp, ++count);
            }
        }

        Integer maxTimes = Collections.max(map.values());
        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()) {
            String w = iterator.next();
            if(map.get(w) == maxTimes) {
                list.add(w);
            }
        }
        return list;
    }
}
