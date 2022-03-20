package com.sun.graph;

import java.util.*;

/**
 * 图的遍历
 */
public class GraphErgodic {
    /**
     * 图的宽度优先遍历
     *
     * @param node 开始遍历的节点
     */
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Set<Node> markedSet = new HashSet<>();
        markedSet.add(node);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.println(node.value);
            for (Node n : node.adjacentNodes) {
                    if (!markedSet.contains(n)) {
                        markedSet.add(n);
                        queue.add(n);
                    }
            }
        }
    }

    /**
     * 图得深度优先遍历
     *
     * @param node 开始遍历的节点
     */
    public static void dfs(Node node) {
        Set<Node> markedSet = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        markedSet.add(node);
        Node current;
        while (!stack.isEmpty()) {
            current = stack.pop();
            System.out.println(current.value);
            for (Node n : current.adjacentNodes) {
                if (!markedSet.contains(n)) {
                    markedSet.add(n);
                    stack.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.adjacentNodes.add(node2);
        node1.adjacentNodes.add(node3);
        node1.adjacentNodes.add(node4);

        node2.adjacentNodes.add(node1);
        node2.adjacentNodes.add(node3);

        node3.adjacentNodes.add(node1);
        node3.adjacentNodes.add(node2);
        node3.adjacentNodes.add(node4);
        node3.adjacentNodes.add(node5);

        node4.adjacentNodes.add(node1);
        node4.adjacentNodes.add(node3);
        node4.adjacentNodes.add(node5);

        node5.adjacentNodes.add(node3);
        node5.adjacentNodes.add(node4);
        dfs(node1);
    }
}
