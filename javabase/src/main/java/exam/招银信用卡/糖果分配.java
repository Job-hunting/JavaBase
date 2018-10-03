package exam.招银信用卡;

import java.util.Arrays;
import java.util.Scanner;

public class 糖果分配 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str1 = scanner.nextLine().split(" ");
        String[] str2 = scanner.nextLine().split(" ");
        int[] array1 = new int[str1.length];
        int[] array2 = new int[str2.length];
        for (int i = 0; i< str1.length;i++) {
            array1[i] = Integer.parseInt(str1[i]);
        }

        for (int j = 0; j< str2.length;j++) {
            array2[j] = Integer.parseInt(str2[j]);
        }

        System.out.println(max(array1,array2));
    }

    public static int max(int[] weiKou, int[] tangGuo) {
        Arrays.sort(weiKou);
        Arrays.sort(tangGuo);
        int i=0;
        int j=0;
        int res = 0;
        while(i < weiKou.length) {
            while(j<tangGuo.length) {
                if(weiKou[i]<=tangGuo[j]){
                    res++;
                    i++;
                    j++;
                    break;
                }
                else {
                    j++;
                }
            }
            if(j==tangGuo.length){
                break;
            }
        }

        return res;
    }
}
