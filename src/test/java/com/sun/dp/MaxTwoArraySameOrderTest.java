package com.sun.dp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Auther: swh
 * @Date: 2019/6/26 20:55
 * @Description:
 */
@RunWith(Parameterized.class)
public class MaxTwoArraySameOrderTest {
    // 字符串a
    private String a;
    // 字符串b
    private String b;
    // 字符串a和字符串b的最大公共子序列
    private int maxSameSize;

    public MaxTwoArraySameOrderTest(String a, String b, int maxSameSize) {
        this.a = a;
        this.b = b;
        this.maxSameSize = maxSameSize;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {"googleg","elgoog",4},
                {"abcda","adcba",3},
                {"BDCABA","ABCBDAB",4}
        });
    }

    @Test
    public void testMaxTwoArraySameOrder() {
        Assert.assertEquals(MaxTwoArraySameOrder.MaxTwoArraySameOrder(a,b),maxSameSize);
    }

}
