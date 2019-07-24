package com.sun.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Spliterator;

/**
 * @Auther: swh
 * @Date: 2019/7/24 22:35
 * @Description: Spliterator 使用练习
 */
public class SpliteratorTest {
    private static final List<Integer> list = new ArrayList<Integer>(10000000) {
        {
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
            add(8);
            for (int i = 0; i < 10000000; i++) {
                add(i);
            }
        }
    };



    @Test
    public void tryAdvanceTest() {
        Spliterator spliterator = list.spliterator();

        boolean isdown;
        do {
            isdown = spliterator.tryAdvance(e -> System.out.println(Thread.currentThread().getName() + ":" + e));
        } while (isdown);
    }

    @Test
    public void forEachTest() {
        Date start = new Date();
        long sum = 0;
        for (int e : list) {
            sum += e;
        }
        System.out.println("sum="+sum);
        Date end = new Date();
        System.out.printf("花费时间:"+(end.getTime()-start.getTime()));
    }
}
