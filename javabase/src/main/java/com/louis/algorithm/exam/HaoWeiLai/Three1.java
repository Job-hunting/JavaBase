package com.louis.algorithm.exam.HaoWeiLai;

import java.util.Scanner;

/**
 * 能分割成多少个被3整除的数
 * */
public class Three1 {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        //获取输入
        String string = in.nextLine();
        in.close();

        int number = 0;
        int result = 0;
        //处理流程
        for(int i = 0;i < string.length();i ++)
        {
            if(Integer.parseInt(string.charAt(i) + "") == 0)
            {
                number ++;
                result = 0;
                continue;
            }

            result += Integer.parseInt(string.charAt(i) + "");
            if(result % 3 == 0 )
            {
                number ++;
                result = 0;
            }
        }

        System.out.println(number);
    }
}
