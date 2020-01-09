package com.sun.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * @Auther: swh
 * @Date: 2020/1/9 22:39
 * @Description:
 */
public class TreeLevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list,root, 0);

        return list;
    }

    private void helper(List<List<Integer>> list, TreeNode treeNode, int leve) {
        if (Objects.isNull(treeNode)) {
            return;
        }
        if (list.size()==leve) {
            list.add(new ArrayList<>());
        }
        list.get(leve).add(treeNode.val);

        helper(list,treeNode.left,leve+1);

        helper(list,treeNode.right,leve+1);

    }
}
