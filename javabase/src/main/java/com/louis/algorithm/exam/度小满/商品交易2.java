package com.louis.algorithm.exam.度小满;

import java.util.Scanner;

public class 商品交易2 {
    private static int count;

    public static double maxProfit(double[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        double maxTotalProfit = 0;
        double inPrice = 0;
        double outPrice = 0;
        int status = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i + 1] > prices[i] && status == 0) {
                inPrice = prices[i];
                status = 1;
                count ++;
            }
            if(prices[i + 1] < prices[i] && status == 1) {
                outPrice = prices[i];
                maxTotalProfit += (outPrice - inPrice);
                status = 0;
            }
        }
        if(status == 1) {
            outPrice = prices[prices.length - 1];
            maxTotalProfit += (outPrice - inPrice);
        }

        return maxTotalProfit;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        double[] prices = new double[num];
        for(int i = 0; i < num; i++) {
            prices[i] = in.nextDouble();
        }
        System.out.print((int)maxProfit(prices) + " " + count * 2);
    }

}
