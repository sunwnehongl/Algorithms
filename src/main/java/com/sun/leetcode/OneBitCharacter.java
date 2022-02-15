package com.sun.leetcode;

public class OneBitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) {
            return true;
        }
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] != 0) {
                if (i == bits.length - 2) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        OneBitCharacter oneBitCharacter = new OneBitCharacter();
        System.out.println(oneBitCharacter.isOneBitCharacter(new int[]{1,1,0,1,1}));
    }
}
