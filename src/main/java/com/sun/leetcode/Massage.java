package com.sun.leetcode;

import java.util.Random;

/**
 * @Auther: swh
 * @Date: 2020/3/24 21:37
 * @Description:
 */
public class Massage {
    public static void main(String[] args) {
        Massage massage = new Massage();
        int[] data = {2,1};
        System.out.println(massage.massage(data));
    }

    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else if(i == 1){
                dp[i] =  Math.max(nums[i],dp[i-1]);
            }else{
                dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            }
        }

        return dp[nums.length-1];
    }

    static void f1(char c) {

    }
}
