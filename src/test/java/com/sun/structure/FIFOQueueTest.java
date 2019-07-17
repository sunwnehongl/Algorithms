package com.sun.structure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.*;

/**
 * @Auther: swh
 * @Date: 2019/6/20 22:41
 * @Description: 先进先出队列测试
 */

@RunWith(Parameterized.class)
public class FIFOQueueTest {


    private String items;
    private String outItems;

    private FIFOQueue<String> queue;

    public FIFOQueueTest(String items,String outItems){
        this.items =items;
        this.outItems = outItems;
    }

    @Parameterized.Parameters
    public static  Collection<String []> getData() {
        return Arrays.asList(new String[][] {
                { "1 2 3 4 5 6", "1 2 3 4 5 6" },
                { "hello", "hello"},
                { "hello world", "hello world"}
        });
    }

    @Before
    public void init() {
        queue = new FIFOQueue();
    }
    @Test
    public void testQueue(){
        String[] itemArray = items.split(" ");
        for (String item : itemArray) {
            queue.enqueue(item);
        }
        List<String> outArray = new ArrayList<>();
        while (!queue.isEmpty()){
            outArray.add(queue.dequeue());
        }

        Assert.assertEquals(outItems, new StringJoiner(" ").add(outItems).toString());
    }
}
