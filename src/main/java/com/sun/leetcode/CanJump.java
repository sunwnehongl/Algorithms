package com.sun.leetcode;

/**
 * @Auther: swh
 * @Date: 2020/2/28 20:13
 * @Description:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanJump {
    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        int[] data = {};
        System.out.println(canJump.canJump(data));
    }

    public boolean canJump(int[] nums) {
        if (nums == null ) {
            return false;
        }
        if (nums.length == 1 || nums.length==0) {
            return true;
        }


        return canJump(nums, 0);
    }

    public boolean canJump(int[] nums, int start) {
        if (nums[start] >= nums.length - 1 - start) {
            return true;
        }
        for (int i = nums[start]; i >= 1; i--) {
            if (canJump(nums,start+i)) {
                return true;
            }
        }
        return false;
    }
}
