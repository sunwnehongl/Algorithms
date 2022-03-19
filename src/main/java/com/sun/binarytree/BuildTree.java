package com.sun.binarytree;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode head = null;
        Queue<Integer> pQ = new LinkedList<>();
        Queue<Integer> iQ = new LinkedList<>();
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            pQ.add(preorder[i]);
            iQ.add(inorder[i]);
        }
        int i;
        int p;
        TreeNode f = null;
        TreeNode node = null;
        boolean isRight = false;
        while (!iQ.isEmpty()) {
            i = iQ.peek();
            p = pQ.poll();
            if (f == null) {
                head = f = new TreeNode(p);
                nodeMap.put(p, f);
            }else {
                node = new TreeNode(p);
                if (!isRight) {
                    f.left = node;
                    f = f.left;
                }else {
                    f.right = node;
                    f = node;
                    isRight =false;
                }
            }
            nodeMap.put(p, f);
            if (i == p) {
                while (!iQ.isEmpty() && nodeMap.containsKey(iQ.peek())) {
                    i = iQ.poll();
                    f = nodeMap.get(i);
                }
                isRight = true;
            }
        }
        return head;
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
