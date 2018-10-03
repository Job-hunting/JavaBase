package exam.知乎;

import java.util.Scanner;

public class 最大数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String m = str.split(" ")[0];
        int n = Integer.parseInt(str.split(" ")[1]);
        int len = m.length();
        int[] array = new int[len];
        for (int i = 0; i < m.length(); i++){
            array[i] = m.charAt(i)-'0';
        }
        int newLen = len-n;
        int[] array2 = new int[newLen];
        for (int i = len - newLen, j = 0; j < newLen; i++, j++)
            array2[j] = array[i];
        int max=0;
        for (int i = 0; i < newLen; i++)
        {
            int flag = 1;
            for (int j = max; j < len - newLen+i; j++)//+i很重要
            {
                if (array2[i] <= array[j])
                {
                    array2[i] = array[j];
                    max = j;
                    array[max] = '0';//最大位重新置为0，下一次搜索从这里开始，但不能重复使用这一位
                    flag = 0;
                }
            }
            if (flag == 1) break;
        }
        for (int i = 0; i < newLen; i++)
            System.out.print(array2[i]);

    }

}
