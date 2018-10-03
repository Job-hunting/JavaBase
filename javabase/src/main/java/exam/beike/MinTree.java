package exam.beike;

import java.util.Scanner;
/**
 * 题目描述：
 * 山区里有N个村庄，第i个村庄的海拔高度为Ai。现在要在村庄之间修建道路，使得从每个村庄出发，都能到达其它所有村庄。在第i和第j个村庄之间修建道路的费用取决于海拔较高的村庄的高度，即费用为max{Ai，Aj}，那么修建道路的总费用最少是多少？
 * 输入
 * 第一行包含一个整数N，2≤N≤105。
 * 第二行包含N个空格隔开的整数A1到AN，0≤Ai≤104。
 * 输出
 * 输出修建道路的最小费用。
 *
 * 样例输入
 * 5
 * 4 1 8 2 5
 * 样例输出
 * 19
 * */
public class MinTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String scannerIn = scanner.nextLine();
        String str[] = scannerIn.split(" ");
        int array [] = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            array[i] = Integer.parseInt(str[i]);
        }

        int sum = 0;
        Sort(array);
        for (int i = 1; i<array.length; i++) {
            sum = sum + array[i];
        }
        System.out.println(sum);
    }

    public static void Sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                min = arr[j] < arr[min] ? j : min;
            }
            swap(arr, i, min);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
