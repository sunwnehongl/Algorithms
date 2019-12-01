package com.sun.leetcode;

/**
 * @Auther: swh
 * @Date: 2019/11/30 21:30
 * @Description:
 */
public class MinPathSum {

    public static void main(String[] args) {
        MinPathSum pathSum = new MinPathSum();

        int[][] grid = {{1,2},{5,6},{1,1}};
        System.out.println(pathSum.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
             }
        }

        return dp[grid.length - 1][grid[0].length -1];

    }
}
