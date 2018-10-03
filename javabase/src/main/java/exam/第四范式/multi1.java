package exam.第四范式;

import java.math.BigDecimal;
import java.util.Scanner;

public class multi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();
        BigDecimal bigDecimal = new BigDecimal(num1);
        BigDecimal bigDecimal2 = new BigDecimal(num2);
        BigDecimal bigDecimal3 = bigDecimal.multiply(bigDecimal2);
        System.out.println(bigDecimal3.toString());

    }
}
/**
 * char[] c = num1.toCharArray();
 *         char[] c2 = num2.toCharArray();
 *         long result = 0L;
 *         int m = 0;
 *         for (int i = c.length-1; i>=0;i--){
 *             int a = c[i] - '0';
 *             for (; m<c.length-1-i;m++){
 *                 a = a*10;
 *             }
 *             int n = 0;
 *             for (int j = c2.length-1; j>=0;j--) {
 *                 int b = c2[j] - '0';
 *                 for ( n = 0; n<c.length-1-j;n++){
 *                     b = b*10;
 *                 }
 *                 result = result + a*b;
 *             }
 *         }
 *         System.out.println(result);
 * */
/**
 *
 public class Solution{
 public String multiply(String num1, String num2){
 int len1=num1.length(),  len2=num2.length();
 int[] num=new int[len1+len2];
 int n=num.length;

 for(int i=len1-1;i>=0;i--){
 for(int j=len2-1;j>=0;j--){
 //不考虑进位
 num[i+j+1]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
 }
 }

 //确保每个数字大小在0~9之间
 int carry=0;
 for(int i=n-1;i>=0;i--){
 num[i]+=carry;
 carry=num[i]/10;
 num[i]=num[i]%10;
 }
 String result="";
 boolean firstNonzero=false;

 //将数组转换为字符串，如果第一位是0，去掉
 for(int i=0;i<n;i++){
 //找出第一个非0的数字
 if(!firstNonzero && num[i]==0)
 continue;
 else{
 result+=num[i];
 firstNonzero=true;
 }
 }

 if(result.equals("") )  return "0";
 return result;

 }
 }
 * */
