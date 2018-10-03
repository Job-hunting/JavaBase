package exam.Company360;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
* 全部ac
* */
public class flower {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int n =  scanner.nextInt();
        int m = scanner.nextInt();
        int arr[] = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int Q = scanner.nextInt();
        for (int i= 0;i<Q;i++){
            int a = scanner.nextInt()-1;
            int b = scanner.nextInt()-1;
            Map<Integer,Integer> map = new HashMap<>();
            int sum = 0;
            for (int j=a;j<=b;j++){
                if(!map.containsKey(arr[j])){
                    map.put(arr[j],1);
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
}
