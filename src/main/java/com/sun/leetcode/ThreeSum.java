package com.sun.leetcode;

import java.util.*;

/**
 * 题目描述
 * 评论 (988)
 * 题解(198)
 * 提交记录
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * @Auther: swh
 * @Date: 2019/12/4 19:30
 * @Description:
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();

        int[] data = {3,0,-2,-1,1,2};
        System.out.println(threeSum.threeSum(data));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> numList = new ArrayList<>();
        if (nums.length <= 2) {
            return numList;
        }

        Arrays.sort(nums);
        int length = nums.length;
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i < length - 1; i++) {
            int left= i-1;
            int right = i+1;
            while (left >= 0 &&  right< length ) {
                int sum = nums[left] + nums[i] + nums[right];
                if (sum > 0) {
                    if ((nums[i] + nums[right]) > Math.abs(nums[0])) {
                        break;
                    }
                    left--;
                } else if (sum < 0) {
                    if (Math.abs(nums[i] + nums[left]) > nums[length - 1]) {

                        break;
                    }
                    right++;
                } else {
                    String key = String.valueOf(nums[left]) + String.valueOf(nums[i]) + String.valueOf(nums[right]);
                    if (map.get(key) == null) {
                        numList.add(Arrays.asList(nums[left], nums[i], nums[right]));
                        map.put(key, "1");
                        left--;
                    } else {
                         left--;
                    }


                }
            }

        }
        return numList;
    }

}
