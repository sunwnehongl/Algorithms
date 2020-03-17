package com.sun.leetcode;

/**
 * @Auther: swh
 * @Date: 2020/3/17 22:59
 * @Description: 123. 买卖股票的最佳时机 III
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] data = {1,2,3,4,5};
        System.out.println(maxProfit.maxProfit(data));
    }

    public int maxProfit(int[] prices) {

        if (prices.length < 2) {
            return 0;
        }

        int[][] maxProfit = new int[prices.length][5];
        maxProfit[0][1] = -prices[0];
        for (int i = 0; i <  prices.length; i++) {
            maxProfit[i][3] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < prices.length; i++) {
            maxProfit[i][0] = 0;
            maxProfit[i][1] = Math.max(maxProfit[i - 1][1], maxProfit[i - 1][0] - prices[i]);
            maxProfit[i][2] = Math.max(maxProfit[i - 1][2], maxProfit[i - 1][1] + prices[i]);
            maxProfit[i][3] = Math.max(maxProfit[i - 1][3], maxProfit[i - 1][2] - prices[i]);
            maxProfit[i][4] = Math.max(maxProfit[i - 1][4], maxProfit[i - 1][3] + prices[i]);
        }
        return Math.max(maxProfit[prices.length-1][2],maxProfit[prices.length-1][4]);
    }
}
