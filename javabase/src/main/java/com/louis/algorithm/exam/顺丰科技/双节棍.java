package com.louis.algorithm.exam.顺丰科技;

import java.util.ArrayList;
import java.util.Scanner;


public class 双节棍 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(getMaxString(string));
    }


    public static String getMaxString(String str){
        String result = "";
        if (str == null || str.length()<3) {
            result = "NULL";
        }
        char[] chars = str.toCharArray();
        ArrayList<Character> charList = new ArrayList<>();
        ArrayList<Integer> IntegerList = new ArrayList<>();

        charList.add(chars[0]);
        int length = 0;
        for (int i = 1; i < chars.length; i++) {
            if(chars[i]==charList.get(charList.size()-1)){
                length++;
            }else{
                IntegerList.add(length+1);
                length = 0;
                charList.add(chars[i]);
            }
        }
        IntegerList.add(length+1);

        int max = 0;
        String res = "";
        for (int i = 0; i < IntegerList.size()-2; i++) {
            int min = IntegerList.get(i) >= IntegerList.get(i+2)?IntegerList.get(i+2):IntegerList.get(i);
            if(min>IntegerList.get(i+1)){
                int temp = min*2 + IntegerList.get(i+1);
                if(temp>max){
                    max = temp;
                    res = exits(charList.get(i),min)+exits(charList.get(i+1),IntegerList.get(i+1))+exits(charList.get(i+2),min);
                }
            }

        }
        if(res == ""){
            result = "NULL";
        }else{
            result = res;
        }
        return result;
    }

    public static String exits(Character c, Integer len) {
        String str = "";
        for (int i = 0; i < len; i++) {
            str += c;
        }
        return str;
    }

    public static boolean contains(ArrayList<Character> list, char c) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == c){
                return true;
            }
        }
        return false;
    }

}

