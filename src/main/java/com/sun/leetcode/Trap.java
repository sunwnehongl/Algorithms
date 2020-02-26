package com.sun.leetcode;

import java.util.Stack;

/**
 * @Auther: swh
 * @Date: 2020/2/22 20:17
 * @Description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap {
    public static void main(String[] args) {
        Trap trap = new Trap();
        int[] data = {4,2,3};
        System.out.println(trap.trap2(data));
    }

    public int trap(int[] height) {
        int ans = 0;

        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }


    public int dpTrap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        maxLeft[0] = height[0];
        maxRight[height.length - 1] = height[height.length - 1];

        for (int i = 1; i <= height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1],height[i]);
        }
        for (int i = height.length - 2; i >= 0 ; i--) {
            maxRight[i] = Math.max(maxRight[i+1],height[i]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            ans += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return ans;
    }


    public int stackTrap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                int bounded = Math.min(height[stack.peek()],height[i]) - height[top];
                ans += distance * bounded;
            }
            stack.push(i);
        }
        return ans;
    }

    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }else{
                    ans += (leftMax - height[left]);
                }
                left ++;
            }else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                }else {
                    ans += (rightMax - height[right]);
                }
                right --;
            }
        }
        return ans;
    }

}
