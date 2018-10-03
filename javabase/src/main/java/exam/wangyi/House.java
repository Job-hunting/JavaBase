package exam.wangyi;
/**
 * m = int(input())
 * list_all = []
 * for i in range(m):
 *     list_i = list(map(int,input().split(' ')))
 *     list_all.append(list_i)
 * for list_use in list_all:
 *     if list_use[0]<=2:
 *         print('0 0')
 *     elif list_use[1]<2:
 *         print('0 0 ')
 *     elif list_use[0]==list_use[1]:
 *         print('0 0')
 *     else:
 *         if (list_use[0]-list_use[1])>list_use[1]-1:
 *             print('0 '+str(list_use[1]-1))
 *         else:
 *             print('0 '+str(list_use[0]-list_use[1]))
 * */
import java.util.Scanner;

public class House {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);
        int t = scanner.nextInt();
        int[][] array =  new int[t][2];
        for(int i=0 ;i<t;i++){
            String str = scanner.nextLine();
            array[i][0] = Integer.parseInt(str.split(" ")[0]);
            array[i][1] = Integer.parseInt(str.split(" ")[1]);
        }
        for(int i=0 ;i<t;i++){
            int a = array[i][0];
            int b = array[i][1];
            if(a<=2){
                System.out.println(0+" "+0);
            } else if(b<=2){
                System.out.println(0+" "+0);
            } else if(a==b){
                System.out.println(0+" "+0);
            } else {
                if(a-b+1>b) {
                    System.out.println(0 + " "+ (b-1));
                } else {
                    System.out.println(0 + " "+ (a-b));
                }
            }

        }

    }
}
