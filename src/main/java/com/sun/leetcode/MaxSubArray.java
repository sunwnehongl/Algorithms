package com.sun.leetcode;

/**
 * @Auther: swh
 * @Date: 2020/3/25 22:04
 * @Description:
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            dp[i] = Math.max(nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
