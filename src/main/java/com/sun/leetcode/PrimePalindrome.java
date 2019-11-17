package com.sun.leetcode;

/**
 * 求出大于或等于 N 的最小回文素数。
 *
 * 回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
 *
 * 例如，2，3，5，7，11 以及 13 是素数。
 *
 * 回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
 *
 * 例如，12321 是回文数。
 *
 * @Auther: swh
 * @Date: 2019/11/17 22:02
 * @Description:
 */
public class PrimePalindrome {

    public static void main(String[] args) {
        PrimePalindrome primePalindrome = new PrimePalindrome();
        System.out.printf(primePalindrome.primePalindrome(9989900)+"");
    }

    public int primePalindrome(int n) {

        StringBuilder sb = null;

        for (int i = 1; i <= 5; i++) {

            for (int start = (int)Math.pow(10, i - 1); start < Math.pow(10, i); start++) {
                sb = new StringBuilder(String.valueOf(start));
                for (int j = i - 2; j >= 0; j--) {
                    sb.append(sb.charAt(j));
                }
                int num = Integer.parseInt(sb.toString());
                if (num >= n && isPrime(num)) {
                    return num;
                }
            }

            for (int start = (int)Math.pow(10, i - 1); start < Math.pow(10, i); start++) {
                sb = new StringBuilder(String.valueOf(start));
                for (int j = i - 1; j >= 0; j--) {
                    sb.append(sb.charAt(j));
                }
                int num = Integer.parseInt(sb.toString());
                if (num >= n && isPrime(num)) {
                    return num;
                }
            }

        }
        return 0;
    }

    /**
     * 检查数n是否为素数
     * @param n 数n
     * @return 是否为素数
     */
    private boolean isPrime(int n) {

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if ( n % i == 0) {
                return false;
            }
        }

        if (n == 1) {
            return false;
        }
        return true;
    }
}
