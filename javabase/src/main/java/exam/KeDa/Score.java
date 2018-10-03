package exam.KeDa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Score {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int X = scanner.nextInt();
            long total = n*X;
            ArrayList<Integer> list1 = new ArrayList<>();
            long sum = 0;
            for (int j = 0; j < n; j++) {
                int a = scanner.nextInt();
                sum = sum + a;
                list1.add(a);
            }
            if (sum == total) {
                System.out.println(0);
                return;
            }
            long sub = total - sum;
            int result = 0;
            long temp = 0;
            Collections.sort(list1);
            for (int j = n-1; j >=0; j--){
                temp = sub - (100-list1.get(i));
                if(sub == temp) {
                    continue;
                }
                sub = temp;
                result = result+1;
                if(sub<=0) {
                    break;
                }
            }
            list.add(result);
        }
        for (int i = 0; i<list.size();i++) {
            System.out.println(list.get(i));
        }
    }
}