package com.sun.sort;

import org.junit.Test;

/**
 * @Auther: swh
 * @Date: 2019/7/17 22:11
 * @Description:
 */
public class QuickSortTest {

    @Test
    public void sort() {
        int[] data = {5,4,10,2,1,9};
        QuickSort.sort(data, 0, data.length - 1);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }

    }
}
