package com.louis.algorithm.exam.头条;

import java.util.HashMap;
import java.util.Scanner;

public class maxString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        String str = scanner.nextLine();
        int result = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0 ;
        for (int i=0;i<str.length();i++){
            if(!map.containsKey(str.charAt(i)) ||  map.get(str.charAt(i))< start){
                map.put(str.charAt(i),i);
            } else {
                result = Math.max(result,i-start);
                start = map.get(str.charAt(i))+1;
                map.put(str.charAt(i),i);
            }
        }

        result = Math.max(result,str.length()-start);

        System.out.println(result);
    }
//    public static int lengthOfLongestSubstring(String s) {
//        HashMap<Character,Integer> map=new HashMap<>();
//        //start保存最长子串的开始下标
//        int start=0,result=0;
//        for(int i=0;i<s.length();i++){
//            //如果字符不在map中，就添加进去
//            if(!map.containsKey(s.charAt(i))||map.get(s.charAt(i))<start){
//                map.put(s.charAt(i),i);
//            }else{
//                //如果在map中，就更新result的值，并且将start+1，成为新的最长子串的开始下标
//                result=Math.max(result,i-start);
//                start=map.get(s.charAt(i))+1;
//                //将这个字符加入到map中
//                map.put(s.charAt(i),i);
//            }
//        }
//        //比较得出result的最大值
//        result=Math.max(result,s.length()-start);
//        return result;
//    }

}
