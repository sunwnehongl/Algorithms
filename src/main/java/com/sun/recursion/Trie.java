package com.sun.recursion;

import java.util.Objects;

public class Trie {
    private Node root = new Node();
    public Trie() {
    }
    public void insert(String word) {
        if (word == null) {
            return;
        }
        Node node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.next[index] == null) {
                node.next[index] = new Node();
            }
            node = node.next[index];
        }
        node.endNum ++;
    }

    public boolean search(String word) {
        if (word == null || Objects.equals("", word)) {
            return false;
        }
        Node node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.next[index] == null) {
              return false;
            }
            node = node.next[index];
        }
        return node.endNum > 0;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        if (Objects.equals("", prefix)) {
            return true;
        }
        Node node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.next[index] == null) {
                return false;
            }
            node = node.next[index];
        }
        return true;
    }

    private static class Node {
        int endNum;
        Node[] next = new Node[26];
    }
}
