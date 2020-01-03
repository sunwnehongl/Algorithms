package com.sun.leetcode;

/**
 * @Auther: swh
 * @Date: 2020/1/3 20:30
 * @Description:
 */
public class SBTree {


    public boolean isSymmetric(TreeNode root) {
        if (root==null) {
            return true;
        }
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left)) {
            return true;
        }
        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
