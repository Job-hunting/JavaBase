package com.louis.algorithm.recursionAndDynamic;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * 打印全部子序列
 * */
public class Subsquences {

	public static void printAllSubsquence(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0);
	}


	public static void process(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}
		process(chs, i + 1);
		char tmp = chs[i];
		chs[i] = 0;
		process(chs, i + 1);
		chs[i] = tmp;
	}
	
	public static void function(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0, new ArrayList<Character>());
	}
	
	public static void process(char[] chs, int i, List<Character> res) {
		if(i == chs.length) {
			printList(res);
		}
		List<Character> resKeep = copyList(res);
		resKeep.add(chs[i]);
		process(chs, i+1, resKeep);
		List<Character> resNoInclude = copyList(res);
		process(chs, i+1, resNoInclude);
	}
	
	public static void printList(List<Character> res) {
		// ...;
	}
	
	public static List<Character> copyList(List<Character> list){
		return null;
	}

    /**
     * 打印
     * */
    public static void printAllSub(char[] str, int i, String res) {
        if (i == str.length) {
            System.out.println(res);  //res是全部的字符累加后的
            return;
        }
        printAllSub(str, i+1, res);  //不加入当前字符
        printAllSub(str, i+1, res+String.valueOf(str[i])); //加入当前字符
    }

	public static void main(String[] args) {
		String test = "abc";
        printAllSub(test.toCharArray(),0,"");
//		printAllSubsquence(test);
	}

}
