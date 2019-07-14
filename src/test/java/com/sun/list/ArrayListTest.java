package com.sun.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: swh
 * @Date: 2019/7/14 11:49
 * @Description: list方法的测试类
 */
public class ArrayListTest {

    /***
     * List 的replaceAll方法测试
     */
    @Test
    public void replaceAllTest() {
        List<Integer> list = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
        }};

        list.replaceAll(integer -> integer*integer);
        list.forEach(integer -> System.out.println(integer));

        System.out.println(-10 >>> 1);
    }

    /***
     * List 的排序算法测试
     * List 如果长度小于7则采用的插入排序，如果长度大于等于7则采用的是归本排序
     */
    @Test
    public void sortTest() {
        List<Integer> list = new ArrayList<Integer>(){{
            add(10);
            add(2);
            add(8);
            add(4);
            add(1);
            add(3);
            add(9);
            add(11);
        }};

        list.sort((x, y) -> Integer.compare(x, y));
        list.forEach(integer -> System.out.println(integer));
    }
}
