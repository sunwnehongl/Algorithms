package com.sun.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: swh
 * @Date: 2020/2/26 21:49
 * @Description:
 */
public class MaxNumberOfBalloons {
    public static void main(String[] args) {
        MaxNumberOfBalloons maxNumberOfBalloons = new MaxNumberOfBalloons();
        maxNumberOfBalloons.maxNumberOfBalloons("nlaebolko");
    }


    public int maxNumberOfBalloons(String text) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            String key = String.valueOf(text.charAt(i));
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        String balloon = "balloon";

        Map<String, Integer> balloonMap = new HashMap<>();
        for (int i = 0; i < balloon.length(); i++) {
            String key = String.valueOf(balloon.charAt(i));
            if (balloonMap.containsKey(key)) {
                balloonMap.put(key, balloonMap.get(key) + 1);
            } else {
                balloonMap.put(key, 1);
            }
        }
        int minTime = Integer.MAX_VALUE;
        for (Map.Entry<String,Integer> entry : balloonMap.entrySet()) {
            if (map.get(entry.getKey()) == null) {
                minTime = 0;
            }else{
                minTime = Math.min(minTime,map.get(entry.getKey())/entry.getValue());
            }
        }
        return minTime;

    }
}
