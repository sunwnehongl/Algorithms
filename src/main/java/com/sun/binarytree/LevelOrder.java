package com.sun.binarytree;

import java.util.*;

public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> nodeList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            nodeList.add(root.val);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
        int[] result = new int[nodeList.size()];
        for (int i = 0; i < nodeList.size(); i++) {
            result[i] = nodeList.get(i);
        }
        nodeList.stream().toArray();
        return result;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
