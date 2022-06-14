package com.sun.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 871. 最低加油次数
 */
public class MinRefuelStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int length = stations.length;
        int[] dp = new int[length + 1];
        dp[0] = startFuel;
        if (length == 0 && startFuel < target) {
            return -1;
        }
        for (int i = 0; i < length; i++) {
            for (int j = i; j >= 0; --j) {
                if (dp[j] >= stations[i][0]) {
                    dp[j+1]  = Math.max(dp[j+1],dp[j] + stations[i][1]);
                }
            }
        }
        for (int i = 0; i <= length; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 优先队列实现方式
     *
     * @param target
     * @param startFuel
     * @param stations
     * @return
     */
    public static int minRefuelStopsForQueue(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int fuel = startFuel;
        int result = 0;
        int pre = 0;
        for (int i = 0; i < stations.length; i++) {
            int location = stations[i][0];
            int capacity = stations[i][1];
            fuel -= location - pre;
            while (!queue.isEmpty() && fuel < 0) {
                fuel += queue.poll();
                result++;
            }
            if (fuel < 0) {
                return -1;
            }

            target -= location - pre;
            pre = location;
            queue.offer(capacity);
        }
        fuel -= target;
        while (!queue.isEmpty() && fuel < 0) {
            fuel += queue.poll();
            result++;
        }
        if (fuel < 0) return -1;
        return result;
    }

    public static void main(String[] args) {
        int result = minRefuelStopsForQueue( 100,10,new int[][] {{10,60},{20,30},{30,30},{60,40}});
        System.out.println(result);

    }
}
