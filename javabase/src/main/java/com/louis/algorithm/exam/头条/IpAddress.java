package com.louis.algorithm.exam.头条;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IpAddress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str.length()<4||str.length()>12){
            System.out.println(0);
            return;
        }
        List<String> list=new ArrayList<>();
        train(str,list,"", 0, 1);
        System.out.println(list.size());

    }

    public static void train(String s, List<String> list, String temp, int pos,int k){
        if(k==4) {
            if(pos==s.length()||(s.charAt(pos)=='0'&&pos!=s.length()-1)||s.substring(pos).length()>=4||(Long.parseLong(s.substring(pos))>255)) return;
            temp+=s.substring(pos);
            list.add(temp);
            return;
        }
        for(int i=pos;i<s.length();i++)
        {
            String t=s.substring(pos,i+1);
            if(t.length()>=4||Long.parseLong(t)>255||(s.charAt(pos)=='0'&&i!=pos)) break;
            train(s,list,temp+t+".",i+1,k+1);
        }
    }

}
