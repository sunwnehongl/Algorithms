package com.sun.binarytree;

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
}
