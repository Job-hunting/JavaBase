package exam.小红书;

import java.util.Scanner;

/**
 * long long int Count(long long int n){
 *     //1的个数
 *     long long int count = 0;
 *     //当前位
 *     long long int Factor = 1;
 *     //低位数字
 *     long long int LowerNum = 0;
 *     //当前位数字
 *     long long int CurrNum = 0;
 *     //高位数字
 *     long long int HigherNum = 0;
 *     if(n <= 0){
 *         return 0;
 *     }
 *     while(n / Factor != 0){
 *         //低位数字
 *         LowerNum = n - (n / Factor) * Factor;
 *         //当前位数字
 *         CurrNum = (n / Factor) % 10;
 *         //高位数字
 *         HigherNum = n / (Factor * 10);
 *         //如果为0,出现1的次数由高位决定
 *         if(CurrNum == 0){
 *             //等于高位数字 * 当前位数
 *             count += HigherNum * Factor;
 *         }
 *         //如果为1,出现1的次数由高位和低位决定
 *         else if(CurrNum == 1){
 *             //高位数字 * 当前位数 + 低位数字 + 1
 *             count += HigherNum * Factor + LowerNum + 1;
 *         }
 *         //如果大于1,出现1的次数由高位决定
 *         else{
 *             //（高位数字+1）* 当前位数
 *             count += (HigherNum + 1) * Factor;
 *         }
 *         //前移一位
 *         Factor *= 10;
 *     }
 *     return count;
 * }
 *
 * int main(){
 *     long long int a;
 *     while(scanf("%lld",&a) != EOF){
 *         printf("%lld\n",Count(a));
 *     }
 *     return 0;
 * }
 * */
public class 统计1的个数 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        long n = scanner.nextInt();
        System.out.println(Count(n));
    }
    public static long Count(long n){
        long count = 0;
        long c = 1;
        long l= 0;
        long cur = 0;
        long h = 0;
        if(n <= 0){
            return 0;
        }
        while(n / c  != 0){
            l = n - (n / c ) * c ;
            cur = (n / c ) % 10;
            h = n / (c  * 10);
            if(cur == 0){
                count = count + h * c ;
            }
            else if(cur == 1){
                count += h * c  + l + 1;
            }
            else{
                count = count + (h + 1) * c ;
            }

            c = c*10;
        }
        return count;
    }

}
