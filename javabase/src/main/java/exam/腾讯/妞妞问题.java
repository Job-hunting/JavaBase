package exam.腾讯;

import java.util.Scanner;

public class 妞妞问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        int t = scanner.nextInt();
        int[][] nums=new int[t][3];
        for (int i=0;i<t;i++){
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
            nums[i][2] = scanner.nextInt();
        }
        for (int i=0;i<t;i++){
            boolean flag=false;
            for (int j =1; j<=1000; j++){
                if ((j*nums[i][0])%nums[i][1] == nums[i][2]){
                    flag = true;
                    break;
                }
            }
            if (flag){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

}
