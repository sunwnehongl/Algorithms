package com.sun.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Auther: swh
 * @Date: 2020/2/25 22:01
 * @Description:
 */
public class MatrixReshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums ==null) {
            return null;
        }
        if (nums.length == 0) {
            return new int[0][0];
        }
        int num  =nums.length * nums[0].length;
        if (r *c != num) {
            return  nums;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int[][] data = new int[r][c];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                queue.add(nums[i][j]);
            }
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
               data[i][j] = queue.poll();
            }
        }
        return data;
    }
}
