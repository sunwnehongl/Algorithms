package com.sun.structure;

import java.awt.event.ItemEvent;

/**
 * @Auther: swh
 * @Date: 2019/6/14 22:08
 * @Description: ������ʵ����ѹջ
 */
public class DownwardStack<Itme> {

    // ִ��������׽ڵ������
    private Node firstItme;
    // ���ڼ�¼��ѹջ��Ԫ������Ҳ����Ԫ�صĴ�С
    private int size;
    //����Ľڵ���
    private class Node {
        // �ڵ��ŵ�Ԫ��
        Itme itme;
        // ����ָ����һ���ڵ���������
        Node nextNode;
    }

    /***
     * ����ѹջ�����һ��Ԫ��
     * @param itme ��Ҫ��ӵ�Ԫ��
     */
    public void push(Itme itme) {
        Node oldNode =firstItme;
        firstItme = new Node();
        firstItme.itme = itme;
        firstItme.nextNode = oldNode;
        size++;
    }

    /***
     * ��ջ���Ƴ�һ��Ԫ��
     * @return �Ƴ���Ԫ��Itme
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
     * ������ѹջ�Ĵ�С
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * ������ѹz
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
