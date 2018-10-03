package exam.迅雷;

import java.util.Scanner;

public class 红黑积木求和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int n = Math.abs(B)/A;
        int i = (17/n)+1;
        System.out.println((i-1)*B+(17-i+1)*A);
    }
}
