package com.github.lifelab.leetcode.problemset;

/**
 * 二叉树的最大深度 @https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author Weichao Li (liweichao0102@gmail.com)
 * @since 2019-06-03
 */
public class Solution104 {

    public int maxDepth(TreeNode root) {
        return depth(root, 0);
    }

    private int depth(TreeNode node, int depth) {

        if (node == null) {
            return 0;
        }

        depth++;

        if (node.left == null && node.right == null) {
            return depth;
        }

        int l = 0, r = 0;

        if (node.left != null) {
            l = depth(node.left, depth);
        }

        if (node.right != null) {
            r = depth(node.right, depth);
        }

        return Math.max(l, r);
    }
}
