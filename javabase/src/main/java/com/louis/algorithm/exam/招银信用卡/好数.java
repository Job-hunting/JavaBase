package com.louis.algorithm.exam.招银信用卡;

import java.util.HashMap;
import java.util.Scanner;

public class 好数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(countNum(n));
    }

    public static int countNum(int N)
    {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(8, 8);
        map.put(2, 5);
        map.put(5, 2);
        map.put(6, 9);
        map.put(9, 6);

        for(int i=1; i<=N; i++)
        {
            int temp = i;
            int n = 0;
            int m = 1;

            while(temp > 0)
            {
                int digit = temp % 10;
                if(map.containsKey(digit))
                {
                    n = map.get(digit) * m + n;
                    temp /= 10;
                    m *= 10;
                }
                else
                {
                    break;
                }
            }
            if(temp == 0 && i != n)
                count++;
        }
        return count;
    }
}
