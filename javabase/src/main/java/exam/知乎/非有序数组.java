package exam.知乎;

import java.util.Scanner;

public class 非有序数组 {
    public static  void  main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a= new int[n];
        int[] b = new int[m];
        for (int i = 0; i<n ; i++){
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i<m ; i++){
            b[i] = scanner.nextInt();
        }
        int[] merge = merge(a,b);
        for(int i=0;i<merge.length;i++){
            System.out.print(merge[i]+" ");
        }

    }

    public static int[] merge(int a[],int b[])
    {
        int result[];
        result = new int[a.length+b.length];
        int i=0,j=0,k=0;
        while(i<a.length && j<b.length)
            if(a[i] <= b[j]) {
                result[k++] = a[i++];

            }else{
                result[k++] = b[j++];
            }
        while(i < a.length)
            result[k++] = a[i++];
        while(j < b.length)
            result[k++] = b[j++];
        return result;
    }

}
