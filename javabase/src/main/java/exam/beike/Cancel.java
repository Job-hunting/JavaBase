package exam.beike;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * 题目描述：
 * 在中国某大学内，教室资源十分紧张，有n个社团同时申请了在某一天使用同一间教室，假设第i个社团占用该教室的时间记为[li,  ri]。根据学校的规定，教务部门必须且最多取消一个社团的预约，来满足另外n-1个社团的需求，问学校有多少种取消的方案。(若两社团占用时间分别为[l1, r1]和[l2,  r2]，此时若r1=l2，视为时间没有冲突)
 * 输入
 * 第一行包含一个整数n，表示社团的数量。(1≤n≤5000)。
 * 接下来有n行，每行包含两个整数，表示第i个社团占用该教室的时间为[li, ri](1≤li, ri≤106)
 * 输出
 * 输出第一行包含一个整数m，表示可以删去的社团数量。
 * 输出第二行包含m个整数，分别为可删除的社团编号(从小到大排序)。
 * （如不删除某个预约，则不能算作一种方案。）
 *
 * 样例输入
 * 3
 * 3 10
 * 20 30
 * 1 3
 * 样例输出
 * 3
 * 1 2 3
 *
 * Hint
 * 输入样例2
 * 4
 * 3 10
 * 20 30
 * 1 3
 * 1 39
 *
 * 输出样例2
 * 1
 * 4
 *
 * 输入样例3
 * 3
 * 1 5
 * 2 6
 * 3 7
 *
 * 输出样例3
 * 0
 *
 * 样例解释
 * 样例1中删除 1，2 ，3社团中的任何一个都可以使得另外两个社团无冲突的使用教室
 * 样例2中删除4以后【1，3】【3，10】【20，30】无冲突，若删除1，2，3中任何一个都会与4冲突。
 * */
public class Cancel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int array[][] = new int[N][2];
        for (int i = 0; i<N ; i++) {
            String scannerIn = scanner.nextLine();
            String str[] = scannerIn.split(" ");
            for (int j = 0; j< str.length; j++) {
                array[i][j] = Integer.parseInt(str[j]);
            }
        }

        int total = 0;
        int result[]  = new int[array.length];
        for (int i = 0; i< array.length; i++) {
            boolean isRight = true;
            int a = array[i][0];
            int b = array[i][1];
            for (int j = i+1; j< array.length; j++) {
                int c = array[j][0];
                int d = array[j][1];
                if (a>=d || c>=b) {
                   continue;
                }
                if (c>=b || a>=d) {
                    continue;
                }
                isRight = false;
            }
            if (isRight){
                total++;
                result[total-1] = i+1;
            }
        }
        System.out.println(total);
        String str = "";
        for (int i = 0; i< result.length; i++) {
            if (result[i] == 0) {
                break;
            }
            str = str + result[i] + " ";
        }
        str = str.toString();
        System.out.println(str);
    }
}
