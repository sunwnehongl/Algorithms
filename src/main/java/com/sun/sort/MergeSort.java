package com.sun.sort;

/**
 * @Auther: swh
 * @Date: 2019/7/13 11:46
 * @Description: 归并排序的实现
 */
public class MergeSort {

    public static void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    private static void sort(int[] data, int start, int end) {

        if (start < end) {
            int dividing = (start +end)/2;
            sort(data, start, dividing);
            sort(data, dividing+1, end);

            merge(data, start, end, dividing);

        }
    }

    private static void merge(int[] data, int start, int end,int dividing) {

        int[] temp = new int[data.length];

        for (int i = start; i <= end; i++) {
            temp[i] = data[i];
        }

        int a = start;
        int b = dividing +1;
        for (int i = start; i <= end; i++) {
            if (a > dividing) {
                data[i] = temp[b++];
            } else if (b > end) {
                data[i] = temp[a++];
            }else if (temp[a]<temp[b]){
                data[i] = temp[a++];
            }else{
                data[i] = temp[b++];
            }
        }
    }


    /***
     * 对数组的两个下标位置的值交换
     * @param data 数组
     * @param a 下标a
     * @param b 下标b
     */
    private static void change(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}

