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
    }
}
