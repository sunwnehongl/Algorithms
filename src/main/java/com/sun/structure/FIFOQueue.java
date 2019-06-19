package com.sun.structure;

/**
 * @Auther: swh
 * @Date: 2019/6/19 22:44
 * @Description: 先进先出队列的实现
 */
public class FIFOQueue<Item> {

    // 执行链表的首节点的引用
    private Node firstItem;
    // 指向链表最后一个节点的引用
    private Node lastItem;
    // 用于记录下压栈的元素数量也就是元素的大小
    private int size;
    //链表的节点类
    private class Node {
        // 节点存放的元素
        Item item;
        // 链表指向下一个节点对象的引用
        Node nextNode;
    }

    /***
     * 返回下队列的大小
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 返回下压z
     * @return 返回队列是否为空
     */
    public boolean isEmpty() {
        return firstItem == null;
    }

    /***
     * 元素入队列
     * @param item 加上的元素
     */
    public void enqueue(Item item) {
        Node oldLastNode = lastItem;
        lastItem = new Node();
        lastItem.item = item;
        if (isEmpty()) {
            firstItem = lastItem;
        } else {
            oldLastNode.nextNode = lastItem;
        }
        size ++;
    }

    /***
     * 元素出队列
     * @ item 返回元素
     */
    public Item dequeue() {
        Item item = firstItem.item;
        firstItem = firstItem.nextNode;
        if (isEmpty()) {
            lastItem = null;
        }
        size --;
        return item;
    }
}
