package com.louis.algorithm.letcode;

/**
 * @author duansaisai
 * @date 2020-10-11 21:56
 */
public class 二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int k = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            if (matrix[i][0] > target) {
                continue;
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] > target) {
                   break;
                }
            }
        }
        return false;
    }
}
