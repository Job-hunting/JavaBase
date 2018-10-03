package exam.腾讯;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 *
 int gcd(int n,int m)//两个数的最大公约数
 {
 return m==0?n:gcd(m,n%m);
 }

 int lcm(int n,int m)//两个数的最小公倍数
 {
 return n*m/gcd(n,m);
 }

 int solve(int num[])//循环求多个数的最小公倍数
 {
 int result=lcm(num[1],num[2]);
 for(int i=2;i<=m-1;i++)
 result=lcm(result,num[i+1]);
 return result;
 }

 int main()
 {
 cin>>n;
 int c=1;
 for(int i=1;i<=n;i++)
 {
 cin>>m;
 for(int j=1;j<=m;j++)
 cin>>num[j];
 cout<<"Case "<<c<<": "<<solve(num)<<endl;
 cout<<endl;
 c++;
 }
 return 0;
 }
 * */
public class 最小公倍数 {
    public static int gcd(int n,int m)//两个数的最大公约数
    {
        return m==0?n:gcd(m,n%m);
    }

     public static int lcm(int n,int m)//两个数的最小公倍数
    {
        return n*m/gcd(n,m);
    }

//    public static int solve(int num[])//循环求多个数的最小公倍数
//    {
//        int result=lcm(num[1],num[2]);
//        for(int i=2;i<=m-1;i++)
//            result=lcm(result,num[i+1]);
//        return result;
//    }
    public static int solve(List<Integer> list)//循环求多个数的最小公倍数
    {
        int result=lcm(list.get(0),list.get(1));
        for(int i=1;i<list.size();i++)
            result=lcm(result,list.get(i+1));
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i = n+1; ;i++){
            list.add(i);
            int j = 1;
            for(;j<=i;j++) {
                list2.add(j);
            }
            if(list.size() == 1) {
                if(list2.size() == 1 && list2.get(0) == list.get(0)){
                    System.out.println(j);
                    return;
                } else {
                    if(list.get(0) == solve(list2)) {
                        System.out.println();
                        return;
                    }
                }
            }
            if(solve(list) == solve(list2)) {
                System.out.println(j);
                return;
            }
        }
    }
}
