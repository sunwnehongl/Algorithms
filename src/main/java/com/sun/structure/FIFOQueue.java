package com.sun.structure;

/**
 * @Auther: swh
 * @Date: 2019/6/19 22:44
 * @Description: �Ƚ��ȳ����е�ʵ��
 */
public class FIFOQueue<Item> {

    // ִ��������׽ڵ������
    private Node firstItem;
    // ָ���������һ���ڵ������
    private Node lastItem;
    // ���ڼ�¼��ѹջ��Ԫ������Ҳ����Ԫ�صĴ�С
    private int size;
    //����Ľڵ���
    private class Node {
        // �ڵ��ŵ�Ԫ��
        Item item;
        // ����ָ����һ���ڵ���������
        Node nextNode;
    }

    /***
     * �����¶��еĴ�С
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * ������ѹz
     * @return ���ض����Ƿ�Ϊ��
     */
    public boolean isEmpty() {
        return firstItem == null;
    }

    /***
     * Ԫ�������
     * @param item ���ϵ�Ԫ��
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
     * Ԫ�س�����
     * @ item ����Ԫ��
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
