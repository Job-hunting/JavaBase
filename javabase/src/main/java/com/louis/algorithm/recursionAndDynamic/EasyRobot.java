package com.louis.algorithm.recursionAndDynamic;

public class EasyRobot {

    /**
     * N一共有N个位置
     * M来到的位置
     * P可以走的位置
     * K最终停留的位置
     * 返回值：一共有多少种走法
     *
     * M，P是变化的变量，动态规划改成后是个杨辉三角性
     * */
    public static int ways(int N,int M,int P, int K){
        if(N < 2 || M < 1 || M>N || P < 1 || K < 1 || K > N){
           return 0;
        }

        if (P == 0) {
            return M ==K ? 1:0;
        }
        int res = 0;
        if (M == 1) {  //在最左边
            res = ways(N,M+1, P-1,K);
        } else if (M == N) {  //在最右边
            res = ways(N,M-1,P-1,K);
        } else {
            res = ways(N,M+1, P-1,K) + ways(N,M-1,P-1,K);
        }
        return res;
    }
}
