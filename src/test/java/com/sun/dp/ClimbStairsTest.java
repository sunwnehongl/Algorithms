package com.sun.dp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Description 台阶问题测试类
 * @Author sunwenhong
 * @Date 2020/12/11 23:28
 */
@RunWith(Parameterized.class)
public class ClimbStairsTest {
    // 台阶数
    private int steps;
    // d对应条台阶的走法总数
    private int methods;
    public ClimbStairsTest(int steps, int methods) {
        this.steps = steps;
        this.methods = methods;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> init() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {2, 2},
                {3, 3},
                {4, 5}
        });
    }

    @Test
    public void climbStairs_test() {
        ClimbStairs climbStairs = new ClimbStairs();
        Assert.assertEquals(climbStairs.climbStairs(steps),methods);
    }
}
