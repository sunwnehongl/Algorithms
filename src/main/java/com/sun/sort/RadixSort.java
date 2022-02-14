package com.sun.sort;

public class RadixSort {
    private static void sort(int[] array) {
        radixSort(array, getMaxDigit(array));
    }

    private static int getMaxDigit(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int n : array) {
            if (max < n) {
                max = n;
            }
        }
        int digit = 1;
        while ((max = (max / 10)) > 0) {
            digit++;
        }
        return digit;
    }

    private static void radixSort(int[] array, int digit) {
        int radix = 10;
        int[] bucket = new int[array.length];
        for (int i = 1; i <= digit; i++) {
            int[] count = new int[radix];
            for (int n : array) {
                int j = getDigit(n, i);
                count[j]++;
            }
            for (int k = 1; k < radix; k++) {
                count[k] = count[k] + count[k - 1];
            }
            for (int k = array.length - 1; k >= 0; k--) {
                int n = array[k];
                int j = getDigit(n, i);
                bucket[count[j] - 1] = n;
                count[j]--;
            }
            for (int k = 0; k < array.length; k++) {
                array[k] = bucket[k];
            }
        }
    }
    private static int getDigit(int num, int digit) {
        return ((int)(num / Math.pow(10, digit - 1)) % 10);
    }

    public static void main(String args[]) {
        int [] array = {1,9,15,3,10,54,36,18,2};
        sort(array);
        for(int a:array) {
            System.out.println(a);
        }
    }
}
