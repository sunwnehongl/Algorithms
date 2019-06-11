package com.sun.structure;

/**
 * @Auther: swh
 * @Date: 2019/6/10 23:07
 * @Description: �̶��������ַ���ջ��ʵ��
 */
public class FixedCapacityStackOfString {

    // ջʵ���������ջ���ݵ��ַ�������
    private String [] items;

    // ջ��ǰ�Ĵ�С��Ҳ����һ��ջ��ֵ���±�
    private int size;

    /***
     * �̶������ַ���ջ�Ĺ�������ֻ��һ������Ϊ�̶�ջ������
     * @param initCapacity ջ������
     */
    public FixedCapacityStackOfString(int initCapacity) {

        if (initCapacity > 0) {
            items = new String[initCapacity];
        }else{
            throw new IllegalArgumentException("Illegal Capacity: "+initCapacity);
        }
    }

    /***
     * ջ��push��������ջ�����һ���ַ���
     * @param item ��ջ����ӵ��ַ���
     */
    public void push(String item) {
        items[size++] = item;
    }

    public String pop() {
       return items[--size];
    }

    public int size() {
        return size;
    }
}
