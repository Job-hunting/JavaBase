package com.louis.algorithm.letcode;

/**
 * @author duansaisai
 * @date 2020-10-25 16:24
 */
public class 矩阵中的路径 {
    public static  boolean exist(char[][] board, String word) {
        char[] wordChar = word.toCharArray();

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, wordChar, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean dfs(char[][] board, char[] wordChar, int curI, int curJ, int index) {
        if (curI < 0 || curJ < 0 || curI > board.length -1 || curJ > board[0].length -1
                || board[curI][curJ] != wordChar[index]) {
            return false;
        }
        if (index == wordChar.length - 1) {
            return true;
        }

        //把当前坐标的值保存下来，为了在最后复原
        char tmp = board[curI][curJ];
        //然后修改当前坐标的值
        board[curI][curJ] = '.';

        if (dfs(board, wordChar, curI - 1, curJ, index + 1)
                || dfs(board, wordChar, curI + 1, curJ, index + 1)
                || dfs(board, wordChar, curI, curJ - 1, index + 1)
                || dfs(board, wordChar, curI, curJ + 1, index + 1)) {
            return true;
        }
        //递归之后再把当前的坐标复原
        board[curI][curJ] = tmp;
        return false;
    }

    public static void main(String[] args) {
        char [][] arr=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "BCCED";
        exist(arr, word);
    }
}
