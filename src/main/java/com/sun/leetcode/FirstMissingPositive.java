package com.sun.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: swh
 * @Date: 2020/2/17 20:43
 * @Description:
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int number : nums) {
            if (number > 0) {
                indexMap.put(number, number);
            }

        }

        for (int i = 1; ; i++) {
            if (indexMap.get(i) == null) {
                return i;
            }
        }

    }
}
