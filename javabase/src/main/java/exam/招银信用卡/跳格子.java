package exam.招银信用卡;

import sun.org.mozilla.javascript.internal.ast.Jump;

import java.util.Scanner;

public class 跳格子 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(Jump(n));
    }
    public static int Jump(int target) {
        if(target ==0 || target == 1) {
            return 1;
        }
        return Jump(target-1) + Jump(target-2);
    }

}
