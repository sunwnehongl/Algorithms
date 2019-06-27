package com.sun.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Auther: swh
 * @Date: 2019/6/27 22:25
 * @Description:
 */
public class KnapsackProblemTest {

    @Test
    public void testGetMaxPrice() {
        Assert.assertEquals(KnapsackProblem.getMaxPrice(10,new int[]{3,4,5},new int[]{4,5,6}),11);
    }
}
