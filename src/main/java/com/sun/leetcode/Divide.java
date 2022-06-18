package com.sun.leetcode;

import java.util.Scanner;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * @Auther: swh
 * @Date: 2019/11/20 20:24
 * @Description:
 */
public class Divide {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(a);
        Divide divide = new Divide();
        System.out.println(11 >> 3);
        System.out.printf(divide.divide(1,1)+"");
    }

    public int divide(int dividend, int divisor) {
        int result = 0;

        boolean sign = (dividend > 0) ^ (divisor > 0);
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;
        while (dividend <= divisor) {
            int tempDivisor = divisor;
            int tempResult = -1;
            while ((tempDivisor << 1) >=dividend) {
                if (tempDivisor < Integer.MIN_VALUE >> 1) break;

                tempDivisor = tempDivisor << 1;
                tempResult = tempResult << 1;
            }
            dividend -= tempDivisor;
            result += tempResult;
        }
        if (sign == false) {
            //防止正数越界 -2147483648 --> 2147483647(2147483648会越界)
            if (result <= Integer.MIN_VALUE) {
                result = Integer.MAX_VALUE;
            } else {
                result = -result;
            }
        }
        return result;
    }
}
