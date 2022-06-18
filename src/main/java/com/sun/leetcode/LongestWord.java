package com.sun.leetcode;



import java.util.*;

public class LongestWord {
    public static String longestWord (String[] words) {
        List<String> l = Arrays.asList(words);
        List<String> list = new ArrayList<>(l);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (String s : list) {
            set.add(s);
        }
        String maxString = null;
        for (String s : list) {
            for (int i = 1; i < s.length(); i++) {
                String start = s.substring(0,i);
                String end = s.substring(i);
                if (set.contains(start) && set.contains(end)) {
                    if (maxString == null || s.length() > maxString.length()) {
                        maxString = s;
                    } else {
                        PriorityQueue<String> queue = new PriorityQueue<String>();
                        queue.add(maxString);
                        queue.add(s);
                        maxString = queue.poll();
                    }
                }
            }
        }
      return  maxString;
    }
    public static void main(String[] args) {
        System.out.println(longestWord(new String[] {"apple","iOS","dog","nana","man","good","goodman"}));
    }
}
