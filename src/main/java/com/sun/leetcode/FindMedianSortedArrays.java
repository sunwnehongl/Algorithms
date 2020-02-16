package com.sun.leetcode;

/**
 * @Auther: swh
 * @Date: 2020/2/16 12:56
 * @Description:
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        int[] a = {1,2};
        int[] b = {3,4};
        findMedianSortedArrays.findMedianSortedArrays(a,b);

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0) {
            return getMedian(nums2);
        }
        if (nums2.length == 0) {
            return getMedian(nums1);
        }
        int[] nums = sortArrays(nums1, nums2);
        return getMedian(nums);

    }

    /**
     * 得到一个数组的中位数
     * @param nums 所求数组
     * @return 中位数
     */
    private double getMedian(int[] nums) {
        int length = nums.length;
        if (length % 2 == 0) {
            return (nums[length / 2 - 1] + nums[length / 2]) / 2.0;
        }else{
            return nums[(length - 1) / 2];
        }
    }

    /**
     * 对两个有序数组合并后排序
     * @param nums1 数组一
     * @param nums2 有序数组二
     * @return 合并后得有序数组
     */
    private int[] sortArrays(int[] nums1, int[] nums2){
        int n = nums1.length;
        int m = nums2.length;
        int[] nums = new int[m + n];
        int count = 0;
        int i = 0;
        int j = 0;
        while (count < nums.length) {
            if (i == n) {
                while (j < m) {
                    nums[count++] = nums2[j++];
                }
                break;
            }

            if (j == m) {
                while (i < n) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            }else{
                nums[count++] = nums2[j++];
            }
        }

        return nums;
    }
}
