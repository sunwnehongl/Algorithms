package com.sun.leetcode;

/**
 * @Auther: swh
 * @Date: 2019/12/1 22:19
 * @Description:
 */
public class NumDecodeings {

    public static void main(String[] args) {
        NumDecodeings numDecodeings = new NumDecodeings();

        System.out.println(numDecodeings.numDecodings("1212"));
    }

    public int numDecodings(String s) {
        int length = s.length();
        if (length == 0 || "0".equals(s) || s.charAt(0) =='0') {
            return 0;
        }
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            int num = Integer.parseInt(s.substring(i - 1, i + 1));
            if (num ==0 || (s.charAt(i)=='0' && num>26)) {
                return 0;
            }
            if (s.charAt(i) == '0' && i >= 2) {
                dp[i] = dp[i - 2];
            }else if (s.charAt(i) == '0' && i < 2) {
                dp[i] = 1;
            } else if (num <= 26 && s.charAt(i - 1) != '0') {
                if (i >= 2) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[length - 1];
    }
}
