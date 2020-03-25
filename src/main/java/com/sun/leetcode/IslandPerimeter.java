package com.sun.leetcode;

/**
 * @Auther: swh
 * @Date: 2020/3/23 22:52
 * @Description:
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int i = 0;i< grid.length; i++) {
            for (int j = 0;j< grid[i].length; j++) {
                if (grid[i][j] == 0) {
                   continue;
                }
                if (j ==0 || grid[i][j-1]==0) {
                    perimeter++;
                }
                if (i ==0 || grid[i -1][j]==0) {
                    perimeter++;
                }
                if (j == grid[i].length -1 || grid[i][j +1]==0) {
                    perimeter++;
                }

                if (i == grid.length -1|| grid[i+1][j]==0) {
                    perimeter++;
                }

            }
        }
        return perimeter;
    }
}
