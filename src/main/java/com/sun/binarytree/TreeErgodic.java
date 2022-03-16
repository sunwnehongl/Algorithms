package com.sun.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树遍历
 */
public class TreeErgodic {
    private static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    /**
     * 先序遍历
     *
     * @param head 头节点
     */
    public void preorder(Node head) {
        if (head == null) {
            return;
        }
        preorder(head.left);
        System.out.println(head.value);
        preorder(head.right);
    }

    /**
     * 先序遍历非递归实现
     *
     * @param head 头节点
     */
    public void preorderTraversal(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node node;
        while (!stack.empty()) {
            node = stack.pop();
            System.out.println(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

    }


    /**
     * 后续遍历非递归实现
     *
     * @param head 头节点
     */
    public void postorderTraversal(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> stackTemp = new Stack<>();
        stack.push(head);
        Node node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            stackTemp.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while (!stackTemp.isEmpty()) {
            System.out.println(stackTemp.pop().left);
        }
    }

    /**
     * 中序遍历非递归实现
     *
     * @param head 头节点
     */
    public void inorderTraversal(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node node = head;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.println(node.value);
                node = node.right;
            }
        }
    }

    /**
     * 深度优先遍历
     *
     * @param head 树的头节点
     */
    private void dfs(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node node = head;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = head.left;
            } else {
                node = stack.pop();
                System.out.println(node.value);
                head = node.right;
            }
        }
    }

    /**
     * 宽度优先遍历
     *
     * @param head 树的头节点
     */
    private void bfs(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.println(node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
