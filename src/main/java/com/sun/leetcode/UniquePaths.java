package com.sun.leetcode;

/**
 * @Auther: swh
 * @Date: 2019/11/29 21:14
 * @Description:
 */
public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3,3));
    }
    public int uniquePaths(int m, int n) {

        if (m == n || n == 0) {
            return 0;
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
