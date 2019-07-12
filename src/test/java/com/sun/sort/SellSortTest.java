package com.sun.sort;

import org.junit.Test;

/**
 * @Auther: swh
 * @Date: 2019/7/12 23:03
 * @Description:
 */
public class SellSortTest {

    @Test
    public void sort() {
        SellSort sellSort = new SellSort();
        int[] data = {5,4,3,2,1};
        sellSort.sort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }

    }
}
