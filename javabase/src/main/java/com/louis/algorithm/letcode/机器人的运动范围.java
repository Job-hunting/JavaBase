package com.louis.algorithm.letcode;

/**
 * @author duansaisai
 * @date 2020-10-25 18:01
 */
public class 机器人的运动范围 {

    public int movingCount(int m, int n, int k) {
        int cout = 0;
        boolean bool[][] = new boolean[m][n];
        return work(0, 0, m, n, k, bool);
    }
    private int work(int i, int j, int m, int n, int k, boolean bool[][]) {
        if (i < 0 || j < 0 || i > m-1 || j > n -1 || get(i) + get(j) > k || bool[i][j] == true) {
            return 0;
        }
        bool[i][j] = true;
        return 1 + work(i-1, j, m, n, k, bool)
                + work(i, j - 1, m, n, k, bool)
                + work(i, j + 1, m, n, k, bool)
                + work(i + 1, j, m, n, k, bool);
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

}
