package exam.Xiecheng;

import java.util.Scanner;

public class LongCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long input = in.nextLong();
        int r = 0;
        while(input!=0) {
            r = r + 1;
            input = (input-1)&input;
        }
        System.out.println(r);
    }
}
