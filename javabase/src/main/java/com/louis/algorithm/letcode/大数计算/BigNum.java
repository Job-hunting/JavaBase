package com.louis.algorithm.letcode.大数计算;

/**
 * @author duansaisai
 * @date 2020-10-27 16:47
 *
 * 文章：https://zhuanlan.zhihu.com/p/29008333
 */
public class BigNum implements Comparable<BigNum> {

    /**
     * 表示大数的数组
     */
    public final int NUM[];
    /**
     * 表示大数的正负号
     */
    public final char SIGN;
    /**
     * 表示大数的位数
     */
    public final int DIGITS;

    public BigNum(String number) throws Exception {
        if (number == null || number == "") {
            throw new Exception("字符串为空！");
        }
        char numChar[] = number.toCharArray();
        char sign = 0;
        //从左往右获取输入的值
        for (int i = 0; i < numChar.length; i++) {
            //设置大数正负号，以最后一个符号为准
            if (numChar[i] == '+' || numChar[i] == '-') {
                sign = numChar[i];
            }
        }
        if (sign == 0) {
            sign = '+';
        }
        NUM = stringToIntArr(number);
        SIGN = sign;
        DIGITS = NUM.length;
    }

    public BigNum(int[] numArr, char sign) throws Exception {
        if (numArr == null) {
            throw new Exception("数组为空！");
        }
        if (sign != '-' && sign != '+') {
            throw new Exception("符号错误！非正负号！");
        }
        SIGN = sign;
        NUM = stringToIntArr(intArrToString(numArr));
        DIGITS = NUM.length;
    }

    /**
     * 将传入的字符串转换成int数组，该方法为静态方法，会过滤掉开头的零和非数字，
     */
    public static int[] stringToIntArr(String s) {
        char numChar[] = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < numChar.length; i++) {//从左往右获取输入的值
            if (numChar[i] == '0' && flag) {//过滤掉开头的零
                continue;
            }
            if (numChar[i] == '.') {//忽略小数点'.'后的值
                break;
            }
            if (numChar[i] >= '0' && numChar[i] < '9') {//过滤掉非数字
                flag = false;
                sb.append(numChar[i]);
            }
        }

        if (flag) {
            sb.append("0");
        }
        char tempCharArr[] = sb.toString().toCharArray();
        int num[] = new int[tempCharArr.length];
        for (int j = 0; j < num.length; j++) {//将获取到的数字从char转换成int
            num[j] = Integer.valueOf("" + tempCharArr[j]);
        }
        return num;
    }

    /**
     * 将传入的int数组转换成字符串，该方法为静态方法。
     */
    public static String intArrToString(int arr[]) {
        StringBuilder sb = new StringBuilder(arr.length);
        boolean flag = true;
        for (int i : arr) {
            if (i == 0 && flag) {//过滤掉开头的零
                continue;
            }
            flag = false;
            sb.append(i);
        }
        if (flag) {
            sb.append("0");
        }
        return sb.toString();
    }

    /**
     * 比较两个bignum对象的大小，包括符号。
     * 若当前对象小于，等于，大于比较对象，则返回负整数，零，正整数
     *
     * @param num
     *
     * @return
     */
    @Override
    public int compareTo(BigNum num) {
        if (this == num) {
            return 0;
        }
        if (num == null) {
            return 1;
        }
        if (SIGN < num.SIGN) {//当前对象正号      +号的ascll为43，-号为45
            return 1;
        } else if (SIGN > num.SIGN) {//当前对象负号
            return -1;
        } else {//同号
            if (SIGN == '+') {//同正
                if (DIGITS > num.DIGITS) {//位数大
                    return 1;
                } else if (DIGITS < num.DIGITS) {//位数小
                    return -1;
                } else {//位数相同
                    return ArrCompare(NUM, num.NUM);
                }
            } else {//同负，结果全部取反
                if (DIGITS > num.DIGITS) {//位数大
                    return -1;
                } else if (DIGITS < num.DIGITS) {//位数小
                    return 1;
                } else {//位数相同
                    return -1 * ArrCompare(NUM, num.NUM);
                }
            }
        }
    }

    /**
     * 大数数组同位数下比较大小，无符号。
     * 若a小于，等于，大于b，则返回负整数，零，正整数
     *
     * @param a
     * @param b
     *
     * @return
     */
    private int ArrCompare(int a[], int b[]) {
        for (int i = 0; i < b.length; i++) {
            if (a[i] > b[i]) {
                return 1;
            } else if (a[i] < b[i]) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * 判断两个大数数组的大小,无符号。
     * 若当前数组小于，等于，大于比较数组，则返回负整数，零，正整数
     *
     * @return
     */
    private int intArrCompaerTo(int numA[], int numB[]) {
        if (numA == numB) {
            return 0;
        }
        if (numA.length > numB.length) {
            return 1;
        } else if (numA.length < numB.length) {
            return -1;
        } else {
            return ArrCompare(numA, numB);
        }
    }

    public BigNum add(BigNum add) throws Exception {
        int addnum[] = add.NUM;//保存加的数组
        char newNumSign = 0;//保存和的符号
        int newNum[] = null;//保存和的数组
        if (SIGN == add.SIGN) {//同正负号时，符号不变一致
            newNumSign = SIGN;
            newNum = addnum(NUM, addnum);//调用加法
        } else {//异号时，谁的绝对值比较大就用谁的符号
            if (intArrCompaerTo(NUM, addnum) == 1) {
                newNumSign = SIGN;
            } else {
                newNumSign = add.SIGN;
            }
            newNum = subNum(NUM, addnum);//调用减法
        }
        BigNum b = new BigNum(newNum, newNumSign);
        return b;
    }

    private int[] addnum(int a[], int b[]) {
        int p1;//较大大数数组运算指针，指针均从右往左
        int p2;//较小大数数组运算指针
        int num[] = null;//和数组
        int p3;//和数组指针
        if (a.length == b.length) {//当两个大数位数一样时
            p1 = p2 = a.length - 1;
            num = new int[a.length + 1];//加一是因为有可能会多进一位
            p3 = a.length;
            for (; p1 > -1; p1--) {
                int temp = 0;//保存每位之和
                temp = a[p1] + b[p2--];
                if (temp > 9) {//当前位之和大于9要进位
                    num[p3--] = temp % 10;//加上个位
                    num[p3] = temp / 10;//进位
                } else {
                    num[p3--] = temp;
                }
            }
        } else {//两个大数位数不相同时
            int tempNum[] = a;//用临时数组保存当前对象的大数
            if (a.length < b.length) {//tempNum恒存放大的大数，add存放小的大数
                tempNum = b;
                b = a;
            }
            p1 = tempNum.length - 1;
            p2 = b.length - 1;
            num = new int[tempNum.length + 1];
            p3 = tempNum.length;
            for (; p1 > -1; p1--) {
                int temp = 0;//保存每位的和
                if (p2 < 0) {//较小数组可能会先加完
                    temp = tempNum[p1];
                } else {
                    temp = tempNum[p1] + b[p2--];
                }
                if (temp > 9) {//进位
                    num[p3--] = temp % 10;//加上个位
                    num[p3] = temp / 10;//进位
                } else {
                    num[p3--] = temp;
                }
            }
        }
        return num;
    }

    public BigNum sub(BigNum sub) throws Exception {
        int subNum[] = sub.NUM;//减数
        char newNumSign = 0;//保存差的符号
        int newNum[] = null;//保存差的数组
        if (SIGN == sub.SIGN) {//符号相同时
            switch (compareTo(sub)) {//比较大小
                case -1://小于
                    newNumSign = '-';
                    break;
                case 0://等于
                    newNumSign = '+';
                    newNum = new int[1];
                    newNum[0] = 0;
                    break;
                case 1://大于
                    newNumSign = '+';
                    break;
            }
            newNum = subNum(NUM, sub.NUM);//调用减法
        } else {//异号
            if (SIGN == '+') {
                newNumSign = '+';
            } else {
                newNumSign = '-';
            }
            newNum = addnum(NUM, sub.NUM);//调用加法
        }
        BigNum b = new BigNum(newNum, newNumSign);
        return b;
    }

    private int[] subNum(int a[], int b[]) {
        int p1 = 0;//较大大数数组运算指针，指针均从右往左
        int p2 = 0;//较小大数数组运算指针
        int num[] = null;//余数组
        int big[] = a;//保存较大数组，b保存较小数组
        int p3 = 0;//余数组指针

        switch (intArrCompaerTo(a, b)) {//比较两个数组大小，使得big恒保存较大数组
            case -1://a小于b
                big = b;
                b = a;
                p1 = big.length - 1;
                p2 = b.length - 1;
                num = new int[big.length];
                p3 = num.length - 1;
                break;
            case 0://a=b，结果为零，直接返回
                num = new int[1];
                num[0] = 0;
                return num;
            case 1://a大于b
                p1 = big.length - 1;
                p2 = b.length - 1;
                num = new int[big.length];
                p3 = num.length - 1;
                break;
        }
        for (; p1 > -1; p1--) {//以大数组的长度来从右往左运算
            if (p2 < 0) {//当大数组还有数字而小数组没有后执行
                if (big[p1] < 0) {//如果当前位小于0，即在上一次循环中被借了一位，再往前借一次
                    big[p1 - 1] -= 1;
                    big[p1] += 10;
                }
                num[p3--] = big[p1];
            } else {//小数组还有数字
                if (big[p1] < b[p2]) {//大数组的当前位小于小数组的当前位时借位
                    big[p1 - 1] -= 1;
                    big[p1] += 10;
                }
                num[p3--] = big[p1] - b[p2--];
            }
        }
        return num;
    }

    public BigNum mul(BigNum mul) throws Exception {
        int mulNum[] = mul.NUM;//要乘的大数数组
        char newNumSign = 0;//积数的符号
        int newNum[] = null;//积数的数组
        if (SIGN == mul.SIGN) {//同号为正，异号为负
            newNumSign = '+';
        } else {
            newNumSign = '-';
        }
        newNum = mulNum(NUM, mulNum);
        BigNum b = new BigNum(newNum, newNumSign);
        return b;
    }

    /**
     * 大数数组相乘，不分符号
     *
     * @param b
     *
     * @return
     */
    private int[] mulNum(int a[], int b[]) {
        //productNum存放两个数组每个数字互相相乘的积
        int productNum[][] = new int[a.length][b.length];
        //num存放积数，num长度范围，最大：两个数组长度的和，最小：两个数组长度的和减一
        //这里先用最小范围存放，第一位暂时不进位即可
        int num[] = new int[a.length + b.length - 1];
        for (int i = 0; i < a.length; i++) {//两两相乘
            for (int j = 0; j < b.length; j++) {
                productNum[i][j] = a[i] * b[j];
            }
        }
        //二维数组中每一条正斜线的和正是对应位的总积值
        for (int t = 0; t < num.length; t++) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    if (t == i + j) {
                        num[t] += productNum[i][j];
                    }
                }
            }
        }
        for (int i = num.length - 1; i > -1; i--) {//从左往右进位，第一位不进位
            if (num[i] > 9 && i > 0) {
                num[i - 1] += num[i] / 10;
                num[i] %= 10;
            }
        }
        if (num[0] > 9) {//如果第一位需要进位，则先转换成字符串在转换成数组即可
            String s = intArrToString(num);
            num = stringToIntArr(s);
        }
        return num;
    }

    public BigNum div(BigNum div) throws Exception {
        int newNum[] = null;//商数组
        char newNumSign = 0;//商正负号
        if (SIGN == div.SIGN) {//同号为正，异号为负
            newNumSign = '+';
        } else {
            newNumSign = '-';
        }
        if (DIGITS < div.DIGITS) {//被除数位数小于除数，结果直接为零
            newNum = new int[1];
            newNum[0] = 0;
            newNumSign = '+';
        } else if (DIGITS == div.DIGITS) {//被除数位数等于除数
            switch (ArrCompare(NUM, div.NUM)) {//同位数下比较被除数与除数大小
                case -1://被除数小于除数
                    newNum = new int[1];
                    newNum[0] = 0;
                    newNumSign = '+';
                    break;
                case 0://被除数等于除数
                    newNum = new int[1];
                    newNum[0] = 1;
                    break;
                case 1://被除数大于除数
                    newNum = divAndRem(NUM, div.NUM, true);
                    break;
            }
        } else {//被除数位数大于除数
            newNum = divAndRem(NUM, div.NUM, true);
        }
        BigNum b = new BigNum(newNum, newNumSign);
        return b;
    }

    /**
     * 大数数组相除，a为被除数，b为除数，flag值为true返回商数，false返回余数     *
     *
     * @param a
     * @param b
     * @param flag
     *
     * @return
     */
    private int[] divAndRem(int a[], int b[], boolean flag) {
        StringBuilder quotient = new StringBuilder();//保存商数
        StringBuilder remainder = new StringBuilder();//保存余数
        //根据平常进行除法运算的方法来实现
        for (int i = 0; i < a.length; i++) {//被除数从最高位到最低位循环
            remainder.append(a[i]);//添加余数
            if ((i + 1) < b.length) {//如果余数位数小于除数，则给对应商数位赋零，同时进入下一层循环
                quotient.append(0);
                continue;
            }
            //当余数与除数位数一致或大于时判断余数与除数的大小
            switch (intArrCompaerTo(stringToIntArr(remainder.toString()), b)) {
                case -1://余数小于除数，给对应商数位赋零，同时进入下一层循环
                    quotient.append(0);
                    continue;
                case 0://余数等于除数，给对应商数位赋一，同时把余数清零
                    quotient.append(1);
                    remainder.delete(0, remainder.length());
                    break;
                case 1://余数大于除数
                    int remTemp[] = stringToIntArr(remainder.toString());//保存余数的数组
                    int jTemp[] = new int[1];//把j转换成数组以便运算
                    int proTemp[] = null;//保存j与b的乘积
                    for (int j = 1; j < 10; j++) {//最多只能为9
                        jTemp[0] = j;
                        proTemp = mulNum(jTemp, b);
                        int c = intArrCompaerTo(proTemp, remTemp);//保存除数乘商的积与余数的大小比的值
                        if (c == -1 && j != 9) {//积大于余数才继续，并且在商为9时即使积小于余数也要往下执行
                            continue;
                        }
                        if ((c == -1 && j == 9) || c == 0) {
                            //当商为9，积小于余数时，或者积等于余数时，不用将乘积的循环往前跳一次
                        } else {//将乘积的循环往前跳一次
                            jTemp[0] = --j;
                            proTemp = mulNum(jTemp, b);
                        }
                        quotient.append(j);//添加商
                        remainder.delete(0, remainder.length());//清空余数
                        remainder.append(intArrToString(subNum(remTemp, proTemp)));//添加余数减去积的差
                        break;
                    }
                    break;
            }
        }
        return flag ? stringToIntArr(quotient.toString()) : stringToIntArr(remainder.toString());
    }

    public BigNum rem(BigNum rem) throws Exception {
        int newNum[] = null;
        switch (compareTo(rem)) {//比较被除数与除数大小
            case -1://被除数小于除数时余数就是被除数本身
                return this;
            case 0://被除数等于除数时余数为零
                newNum = new int[1];
                newNum[0] = 0;
                break;
            case 1://被除数大于除数
                newNum = divAndRem(NUM, rem.NUM, false);
                break;
        }
        return new BigNum(newNum, '+');
    }

    @Override
    public String toString() {
        return (SIGN == '+' ? "" : SIGN) + intArrToString(NUM);//忽略正号
    }
}