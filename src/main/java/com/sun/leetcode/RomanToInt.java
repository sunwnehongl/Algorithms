package com.sun.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int a = map.get(s.charAt(i));
            int b = map.get(s.charAt(i + 1));
            if (a >= b) {
                sum += a;
            } else {
                sum -= a;
                if (i != s.length() - 2) {
                    sum += b;
                    i++;
                }
            }
        }
        sum += map.get(s.charAt(s.length() - 1));
        return sum;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        System.out.println(romanToInt.romanToInt("I"));
        System.out.println(romanToInt.romanToInt("MCMXCIV"));
    }
}
