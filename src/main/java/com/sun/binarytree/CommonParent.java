package com.sun.binarytree;

import java.util.Stack;

/**
 * 获取两个节点的最低公共父节点
 */
public class CommonParent {
    public Node getCommonParent(Node head, Node a, Node b) {
        if (head == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack1 = new Stack<>();
        stack.push(head);
        Node node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            stack1.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Stack<Node> aParentStack = new Stack<>();
        aParentStack.push(a);
        Stack<Node> bParentStack = new Stack<>();
        bParentStack.push(b);
        Node aParent = a;
        Node bParent = b;
        while (!stack1.isEmpty()) {
            node = stack1.pop();
            if (node.left == aParent || node.right == aParent) {
                aParentStack.push(node);
            }
            if (node.left == bParent || node.right == bParent) {
                bParentStack.push(node);
            }
        }
        int length = Math.min(aParentStack.size(), bParentStack.size());
        Node parent = null;
        for (int i = 0; i < length; i++) {
            aParent = aParentStack.pop();
            bParent = bParentStack.pop();
            if (aParent == bParent) {
                parent = aParent;
            }else {
                break;
            }
        }
        return parent;
    }
    private static class Node {
        public int value;
        public Node left;
        public Node right;
    }
}
