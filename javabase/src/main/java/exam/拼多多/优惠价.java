package exam.拼多多;

import java.util.*;
/**
 *
 * 2 3
 * 5 10
 * 10 6
 * 20 10
 * 30 15
 * */
public class 优惠价 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] array = new int[n];
        int[] array2 = new int[m];
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
           int temp = scanner.nextInt();
            array[i] = temp;
            sum = sum + temp;
        }
        for (int i = 0; i <m ; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            map.put(a,b);
            array2[i] = a;
        }

        Arrays.sort(array);
        Arrays.sort(array2);

        int w = array2.length-1;
        for (int i = array.length-1; i>=0; i--) {
            int temp = array[i];
            while(w>= 0 && array2[w] > temp) {
                w--;
            }
            if(w<0) {
                System.out.println(sum);
                return;
            }
            if(map.get(array2[w]) > 0) {
                sum = sum-map.get(array2[w]);
                map.put(array2[w],0);
                w--;
            } else {
                w--;
            }

        }
        System.out.println(sum);
    }
}
