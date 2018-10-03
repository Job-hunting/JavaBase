package exam.知乎;

import java.util.Scanner;

public class 二分查找 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int tar = scanner.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(getLastIndex(array,tar));
    }
    public static int getLastIndex(int[] array, int tar) {
        int i = 0, j = array.length;
        int mid = (i + j) / 2;

        int p = -1;
        while (i < j) {
            if (array[mid] == tar) {
                p = mid;
                break;
            }
            if (array[mid] > tar) {
                if (j == mid) break;
                j = mid;
                mid = (i + j) / 2;
            } else {
                if (i == mid) break;
                i = mid;
                mid = (i + j) / 2;
            }
        }

        if (p == -1) {
            return -1;
        } else {
            int a = p, b = p;
            while (b < array.length - 1 && array[b + 1] == tar) b++;
            return b;
        }

    }
}
