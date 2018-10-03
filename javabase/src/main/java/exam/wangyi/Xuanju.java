package exam.wangyi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Xuanju {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if (n==1) {
            System.out.println(0);
            return;
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(); //key 选举人，value有几张票
        Map<Integer,Integer> mapDang = new HashMap<Integer,Integer>();  //这个人需要几个糖果
        int[] temp = new int[n];
        int t = 0;
        for(int i= 0;i<n;i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            temp[t++] = y;
            mapDang.put(y,x);
            if(map.get(x) != null) {
                map.put(x,map.get(x)+1);
            }else{
                map.put(x,0);
            }
        }


        Arrays.sort(temp);

    }
}
