package exam.小红书;

import java.util.Scanner;

/**
 *  public int compress(char[] chars) {
 *         if(chars.length == 0) return 0;
 *
 *         int mark = 0;
 *         int write = 0;
 *         for(int i = 0; i < chars.length; i++){
 *             if(i + 1 == chars.length || chars[i] != chars[i+1]){
 *                 chars[write] = chars[mark];
 *                 write++;
 *                 if(mark < i){
 *                     for(char a : (""+(i-mark+1)).toCharArray())
 *                         chars[write++] = a;
 *                 }
 *                 mark = i + 1;
 *             }
 *         }
 *         return write;
 *     }
 * */
public class 字符串压缩算法 {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String string = scanner.nextLine();
        char[] str = string.toCharArray();
        String newstr = "";
        int n = 1;
        for (int i = 0; i < str.length; i++) {
            if(i == str.length-1) {
                if(str[i] == str[i-1]) {
                    newstr = newstr + (n-1) + str[i];
                } else {
                    newstr = newstr + "" + str[i];
                }
            }
            if (i+1<str.length && str[i]!=str[i+1]) {
                if(n>1){
                    newstr = newstr + (n-1) + str[i];
                } else {
                    newstr = newstr + "" + str[i];
                }
                n = 1;
            } else {
                n++;
            }
        }
        System.out.println(newstr);
    }
}
