package exam.beike;

import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * 题目描述：
 * 众所周知，一副扑克牌按大小分为13种牌，每种牌各4个花色，总共52张牌。规定13种牌按从小到大的顺序分别为A23456789TJQK，现在从一副牌中抽取20张，每轮选择下列规则中的一项出牌：
 * ①单牌：任意一张牌，如Q；
 * ②对子：两张大小相同的牌，如77；
 * ③三带：三张大小相同的牌，附带至多一张任意牌，如333A；
 * ④四带：四张大小相同的牌，附带至多两张任意牌，如KKKK58；
 * ⑤顺子：至少五张大小连续的牌，如789TJQ。
 * 那么，至少需要多少轮才能将20张牌出完？
 * 样例输入
 * 8K67A65K27T59K346AK2
 * 样例输出
 * 4
 *
 * Hint
 * 样例解释
 * 4轮出牌顺序为：
 * A234567
 * 56789T
 * KKKKA2
 * 6
 * */
public class puke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String scannerIn = scanner.nextLine();
        char charStr[] = scannerIn.toCharArray();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<charStr.length ;i++) {
            if (charStr[0] == 'A') {
                if (map.get(1) != null) {
                    map.put(1, map.get(1)+1);
                }
                map.put(1, 1);
                continue;
            }
            if (charStr[0] == 'T') {
                if (map.get(10) != null) {
                    map.put(10, map.get(10)+1);
                }
                map.put(10, 1);
                continue;
            }
            if (charStr[0] == 'J') {
                if (map.get(11) != null) {
                    map.put(11, map.get(11)+1);
                }
                map.put(11, 1);
                continue;
            }
            if (charStr[0] == 'Q') {
                if (map.get(12) != null) {
                    map.put(12, map.get(12)+1);
                }
                map.put(12, 1);
                continue;
            }
            if (charStr[0] == 'K') {
                if (map.get(13) != null) {
                    map.put(13, map.get(13)+1);
                }
                map.put(13, 1);
                continue;
            }
            if (map.get(i) != null) {
                map.put(i, map.get(i)+1);
            }
            map.put(i, 1);
        }
        System.out.println(4);
    }
}
