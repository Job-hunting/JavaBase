package exam.头条;

import java.util.Scanner;

public class Island {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int result = 0;
        int[][] array = new int[x][x];
        for (int i = 0;i<x;i++){
            for (int j = 0;j<x;j++){
                array[i][j] = scanner.nextInt();
            }
        }

        if (array == null || array[0] == null) {
            System.out.println(0);
            return;
        }
        int N = array.length;
        int M = array[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (array[i][j] == 1) {
                    result++;
                    add(array, i, j, N, M);
                }
            }
        }
        System.out.println(result);
    }

    public static void add(int[][] m, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2;
        add(m, i + 1, j, N, M); //感染上下左右
        add(m, i - 1, j, N, M);
        add(m, i, j + 1, N, M);
        add(m, i, j - 1, N, M);
    }

}
