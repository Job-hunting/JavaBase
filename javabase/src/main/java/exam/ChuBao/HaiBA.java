package exam.ChuBao;

import java.util.Scanner;

public class HaiBA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //获取输入
        int height = in.nextInt();
        int width = in.nextInt();
        int waterLevel = in.nextInt();
        int[][] array = new int[height][width];
        int sum  = 0;
        for (int i=0; i<height;i++) {
            for (int j=0; j<width;j++){
                int a = in.nextInt();
                array[i][j] = a;
                if (a>waterLevel){
                    sum++;
                }
            }
        }

        for (int i=0; i<height;i++) {
            for (int j=0; j<width;j++){
                if (array[i][j]>waterLevel) {

                }
            }
        }
        System.out.println(sum);
    }
}
