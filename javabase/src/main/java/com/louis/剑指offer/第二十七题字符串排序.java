package com.louis.剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 可以这样想：固定第一个字符a，求后面两个字符bc的排列。当两个字符bc的排列求好之后，我们把第一个字符a和后面的b交换，得到bac;接着我们固定第一个字符b，求后面两个字符ac的排列。现在是把c放到第一位置的时候了。记住前面我们已经把原先的第一个字符a和后面的b做了交换，为了保证这次c仍然是和原先处在第一位置的a交换，我们在拿c和第一个字符交换之前，先要把b和a交换回来。在交换b和a之后，再拿c和处在第一位置的a进行交换，得到cba。
 * 我们再次固定第一个字符c，求后面两个字符b、a的排列。这样写成递归程序如下：
 *
 * */
public class 第二十七题字符串排序 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str != null && str.length() >0) {
            Permutation(str.toCharArray(),0,result);
            Collections.sort(result);
        }
        return result;
    }


    public void Permutation(char[] c, int i, List<String> list){
        if (i == c.length -1) {    //如果遍历i到数组最后了，则开始转化成字符串保存
            String val = String.valueOf(c);
            if(!list.contains(val)){
                list.add(val);
            }
        } else {
            for (int j = i; j<c.length;j++) {
                swap(c,i,j);
                Permutation(c,i+1,list);
                swap(c,i,j);
            }
        }
    }

    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

}
