package com.sun.sort;

import java.util.Stack;

public class MaximumScore {
    public int maximumScore(int[] nums, int k) {
        int max = 0;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.add(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = nums.length;
            } else {
                right[i] = stack.peek();
            }
            stack.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (left[i] + 1 <= k && right[i] - 1 >= k) {
                max = Math.max(max, nums[i] * (right[i] - left[i] - 1));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumScore maximumScore = new MaximumScore();
        System.out.println(maximumScore.maximumScore(new int[]{6569, 9667, 3148, 7698, 1622, 2194, 793, 9041, 1670, 1872}, 5));
    }
}
