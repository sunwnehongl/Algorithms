package com.sun.structure;

import java.awt.event.ItemEvent;

/**
 * @Auther: swh
 * @Date: 2019/6/14 22:08
 * @Description: 用链表实现下压栈
 */
public class DownwardStack<Itme> {

    // 执行链表的首节点的引用
    private Node firstItme;
    // 用于记录下压栈的元素数量也就是元素的大小
    private int size;
    //链表的节点类
    private class Node {
        // 节点存放的元素
        Itme itme;
        // 链表指向下一个节点对象的引用
        Node nextNode;
    }

    /***
     * 向下压栈中添加一个元素
     * @param itme 需要添加的元素
     */
    public void push(Itme itme) {
        Node oldNode =firstItme;
        firstItme = new Node();
        firstItme.itme = itme;
        firstItme.nextNode = oldNode;
        size++;
    }

    /***
     * 从栈顶移除一个元素
     * @return 移除的元素Itme
     */
    public Itme pop() {
        if (firstItme == null) {
            return null;
        }
        Itme itme = firstItme.itme;
        firstItme = firstItme.nextNode;
        size--;
        return itme;
    }

    /***
     * 返回下压栈的大小
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 返回下压z
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
