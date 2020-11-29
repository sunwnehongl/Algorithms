package com.sun.leetcode;

import java.util.Objects;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZigzagTransformation {

    public String convert(String s, int numRows) {
        if ("".equals(s)) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        int length = s.length();
        char[][] array = new char[numRows][length];
        int y = 0;
        int num = 0;
        while (num < s.length()) {
            int x = 0;
            for (int j = 0; j < numRows && num < s.length(); j++) {
                array[x++][y] = s.charAt(num);
                num++;
            }
            x--;
            for (int j = 0; j < numRows - 2 && num < s.length(); j++) {
                array[--x][++y] = s.charAt(num);
                num++;
            }
            y++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < length; j++) {
                if (!(array[i][j] == '\u0000')) {
                    sb.append(array[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ZigzagTransformation zt = new ZigzagTransformation();
        System.out.println(zt.convert("LEETCODEISHIRING", 3));
    }
}
