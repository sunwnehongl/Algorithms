package com.sun.leetcode;

/**
 * @Auther: swh
 * @Date: 2019/11/12 22:00
 * @Description:
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[] a = {1,0,0,0,1};
        System.out.printf(canPlaceFlowers(a,2)+"");
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n==0) {
            return true;
        }
        if (flowerbed.length == 1) {
            if(flowerbed[0] == 0 && n <= 1){
                return true;
            } else {
               return false;
            }
        }
        int maxFlower = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0 ) {
                if (flowerbed[1] == 0 && flowerbed[i] != 1) {

                    maxFlower++;
                    flowerbed[i] = 1;
                }
            } else if (i == flowerbed.length - 1 ) {
                if(flowerbed[i - 1] == 0 && flowerbed[i] != 1){
                    maxFlower++;
                    flowerbed[i] = 1;
                }
            } else if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] != 1) {
                maxFlower++;
                flowerbed[i] = 1;
            }
        }

        if (maxFlower >= n) {
            return true;
        }
        return false;
    }
}
