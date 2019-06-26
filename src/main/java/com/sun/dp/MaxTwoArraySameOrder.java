package com.sun.dp;

/**
 * @Auther: swh
 * @Date: 2019/6/26 20:43
 * @Description:求两个字符串的最大公共子序列（可以不连续）的长度，并输出这个子序列
 * 例如：
 * 输入 googleg和elgoog 输出 4
 * 输入 abcda和adcba 输出 3
 */
public class MaxTwoArraySameOrder {

    public static int MaxTwoArraySameOrder(String a,String b) {
        int max = 0;
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        int[][] sameSizeArray = new int[a.length()+1][b.length()+1];
        for (int i = 1; i < a.length() + 1; i++) {
            for (int j = 1; j < b.length()+1; j++) {
                if (aArray[i - 1] == bArray[j - 1]) {
                    sameSizeArray[i][j] = sameSizeArray[i - 1][j - 1]+1;
                }else{
                    sameSizeArray[i][j] = Math.max(sameSizeArray[i - 1][j],sameSizeArray[i][j-1]);
                }

                if (max < sameSizeArray[i][j]) {
                    max = sameSizeArray[i][j];
                }
            }
        }
        return max;
    }
}
