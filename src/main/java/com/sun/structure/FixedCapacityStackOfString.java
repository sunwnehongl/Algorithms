package com.sun.structure;

/**
 * @Auther: swh
 * @Date: 2019/6/10 23:07
 * @Description: 固定容量的字符串栈的实现
 */
public class FixedCapacityStackOfString {

    // 栈实现用来存放栈内容的字符串数组
    private String [] items;

    // 栈当前的大小，也是下一个栈顶值得下标
    private int size;

    /***
     * 固定容量字符串栈的构造器，只有一个参数为固定栈的容量
     * @param initCapacity 栈的容量
     */
    public FixedCapacityStackOfString(int initCapacity) {

        if (initCapacity > 0) {
            items = new String[initCapacity];
        }else{
            throw new IllegalArgumentException("Illegal Capacity: "+initCapacity);
        }
    }

    /***
     * 栈的push方法，向栈顶添加一个字符串
     * @param item 向栈顶添加的字符串
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
