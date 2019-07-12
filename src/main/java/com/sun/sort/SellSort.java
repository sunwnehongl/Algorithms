package com.sun.sort;

/**
 * @Auther: swh
 * @Date: 2019/7/12 22:50
 * @Description: shell排序的实现
 */
public class SellSort {

    /***
     * 对传入的数组进行从小到大的排序
     * @param data 数组
     */
    public void sort(int[] data) {
        int increment = data.length;
        do {
            increment = increment/3+1;
            for (int i = 0; i+increment < data.length; i++) {
                if (data[i]>data[i+increment]){
                    int j = i;
                    do{
                        j +=increment;
                    }while(j<data.length-increment&&data[j]<data[i]);
                    change(data, i, j);

                }
            }
        } while (increment >1);
    }

    /***
     * 对数组的两个下标位置的值交换
     * @param data 数组
     * @param a 下标a
     * @param b 下标b
     */
    private void change(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
