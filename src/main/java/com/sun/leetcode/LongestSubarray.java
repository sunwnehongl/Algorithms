package com.sun.leetcode;

/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 */
public class LongestSubarray {
    public int longestSubarray(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int l =0;
        int r = 0;
        int result = 0;
        int cost = 1;
        while (r < length) {
            while (r < length) {
                if (nums[r] == 0 && cost == 0) {
                    break;
                }
                if (nums[r] == 0 && cost >= 0) {
                    cost--;
                }
                r++;
            }
            result = Math.max(result, r - l);
            while (cost == 0 && l< r) {
                if (nums[l] == 0) {
                    cost++;
                }
                l++;
            }

        }
        return result - 1;
    }

    public static void main(String[] args) {
        LongestSubarray longestSubarray = new LongestSubarray();
        System.out.println(longestSubarray.longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println(longestSubarray.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        System.out.println(longestSubarray.longestSubarray(new int[]{1,1,1}));
        System.out.println(longestSubarray.longestSubarray(new int[]{0,0,0}));
    }
}
