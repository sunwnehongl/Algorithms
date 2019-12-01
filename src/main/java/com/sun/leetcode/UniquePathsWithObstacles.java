package com.sun.leetcode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * @Auther: swh
 * @Date: 2019/11/29 21:48
 * @Description:
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();

        int[][] data = { {0,0,0},{0,1,0},{0,0,0}};
        int[][] data1 = { {0,1}};
  System.out.println(uniquePathsWithObstacles.uniquePathsWithObstacles(data1));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[0][0] == 0) {
            dp[0][0] = 1;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i - 1][0] != 1 && obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i - 1] != 1 && obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i - 1][j] == 0 && obstacleGrid[i][j] ==0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (obstacleGrid[i][j - 1] == 0 && obstacleGrid[i][j] ==0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
