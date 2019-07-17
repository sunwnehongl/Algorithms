package com.sun.sort;

/**
 * @Auther: swh
 * @Date: 2019/7/17 21:54
 * @Description: 快排代码实现
 */
public class QuickSort {

    public static void sort(int[] data,int start,int end) {
        if (start >= end) {
            return;
        }

        int j = quickSort(data, start, end);
        sort(data, start, j -1);
        sort(data,j +1,end);
    }

    public static int  quickSort(int[] data, int start, int end) {
        int i = start;
        int j = end+1;
        int mid = data[start];
        while (true) {
            while(data[++i]<mid){
                if (i == end) {
                    break;
                }
            }
            while(data[--j]>mid){
                if (j == end) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            change(data,i,j);
        }
        change(data,start,j);
        return j;
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
