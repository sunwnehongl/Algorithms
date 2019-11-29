package com.sun.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @Auther: swh
 * @Date: 2019/11/21 22:02
 * @Description:
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("aaaa"));
    }

    public String longestPalindrome(String s) {

        if (s.length() <= 1) {
            return s;
        }
        int length = s.length();
        int[][] dp = new int[length][length];
        String longestPalindrome = s.substring(0,1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[i - 1][j + 1] == 1)) {
                    dp[i][j] = 1;
                    if (i - j + 1 > longestPalindrome.length()) {
                        longestPalindrome = s.substring(j, i + 1);
                    }

                }
            }
        }

        return longestPalindrome;
    }
}
