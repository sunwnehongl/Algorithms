package com.sun.sort;

import org.junit.Test;

/**
 * @Auther: swh
 * @Date: 2019/7/13 18:19
 * @Description:
 */
public class MergeSortTest {

    @Test
    public void sort() {
        int[] data = {5,4,10,2,1,9};
        MergeSort.sort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }

    }
}
