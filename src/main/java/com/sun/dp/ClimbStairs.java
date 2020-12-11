package com.sun.dp;

/**
 * @Description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * @Author sunwenhong
 * @Date 2020/12/11 23:22
 */
public class ClimbStairs {

    /**
     * 动态规范解决
     * f(x)=f(x−1)+f(x−2)
     * @param n 台阶数
     * @return 走法数
     */
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] ;
        }
        return dp[n];
    }
}
