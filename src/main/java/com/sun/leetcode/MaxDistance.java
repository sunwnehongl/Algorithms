package com.sun.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: swh
 * @Date: 2020/3/29 10:40
 * @Description:
 */
public class MaxDistance {

    public static void main(String[] args) {
        MaxDistance maxDistance = new MaxDistance();
        int[][] data = {{1,0,1},
                {0,0,0},
                {1,0,1}};
        System.out.println(maxDistance.maxDistance(data));

    }
    public int maxDistance(int[][] grid) {
        int distance = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length ; j++) {
                if (grid[i][j] == 0) {
                    distance = Math.max(bfs(grid,i,j),distance);
                }
            }
        }
        return distance;
    }

    private int bfs(int[][] grid, int startX,int startY) {
        Queue<int[]> queue = new LinkedList<>();
        int[] start = {startX,startY};
        queue.offer(start);
        int distance = -1;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int[][] serachGrid = new int[grid.length][grid.length];
        serachGrid[startX][startY] = 1;
        while (!queue.isEmpty()){
            int[] point =  queue.poll();
            int x = point[0];
            int y = point[1];


            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid.length  || serachGrid[newX][newY] == 1) {
                    continue;
                }
                if (grid[newX][newY] == 1 ) {
                    distance = Math.abs(startX - newX) + Math.abs(startY - newY);
                    return distance;
                }
                serachGrid[newX][newY] = 1;
                queue.offer(new int[] {newX, newY});
            }
        }
        return distance;
    }
}
