package com.sun.leetcode;

import com.sun.javafx.css.CascadingStyle;

/**
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 * 说明: 
 *
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * 示例 1:
 *
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 *
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gas-station
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/11/18 23:40
 * @Description:
 */
public class GasStationProblems {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 油箱初始容量为0
        int oilQuantity = 0;
        for (int i = 0; i < gas.length; i++) {
            oilQuantity = 0;
            int siteCount = 0;
            int index = -1;
            for (int j = i; j < gas.length + i; j++) {
                index = j % (gas.length -1);
                if (oilQuantity + gas[index] >= cost[index]) {
                    oilQuantity += gas[index] - cost[index];
                    siteCount++;
                } else {
                    i = index;
                    break;
                }
            }
            if (siteCount == gas.length) {
                return index +1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] grs = {3,3,4};
        int[] cost = {3,3,4};
        GasStationProblems stationProblems = new GasStationProblems();
        int count = stationProblems.canCompleteCircuit(grs,cost);
        System.out.println(count);
    }
}
