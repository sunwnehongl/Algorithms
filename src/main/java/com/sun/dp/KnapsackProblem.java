package com.sun.dp;

/**
 * @Auther: swh
 * @Date: 2019/6/27 21:53
 * @Description:背包问题：给定 n 种物品和一个容量为 C 的背包，物品 i 的重量是 wi，其价值为 vi 。
 * 问：应该如何选择装入背包的物品，使得装入背包中的物品的总价值最大
 */
public class KnapsackProblem {

    /**
     * 求装入背包的的最大价值
     * @param capacity 背包的最大容量
     * @param weight 每件物品的重量
     * @param price 每件物品的价值
     * @return 装入背包中的物品的总价值最大
     */
    public static int getMaxPrice(int capacity, int[] weight, int[] price) {
        int capacityArraySize = capacity + 1;
        int goodsArraySize = weight.length + 1;
        int[][] maxPriceArray = new int[capacityArraySize][goodsArraySize];
        for (int i = 1; i < capacityArraySize; i++) {
            for (int j = 1; j < goodsArraySize; j++) {
                /*
                 如果第j物品等于和小于容量i则最多价值maxPriceArray[i][j]
                 为当前容量减去当前物品的容量时候的最多价值，及maxPriceArray[i-weight[j-1][j-1]
                 和当前容量不加当前物品的最大值，如果当前背包的容量效益当前物品容量，则当前最多价值为
                 前面几种物品为当前容量的最多值。
                 */
                if (weight[j - 1] <= i) {
                    maxPriceArray[i][j] = Math.max(maxPriceArray[i-weight[j-1]][j-1]+price[j-1],maxPriceArray[i][j-1]);
                }else{
                    maxPriceArray[i][j] = maxPriceArray[i][j-1];
                }
            }
        }
        return maxPriceArray[capacity][weight.length];
    }
}
