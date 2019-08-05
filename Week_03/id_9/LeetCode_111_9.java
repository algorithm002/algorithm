package com.github.lifelab.leetcode.problemset;

import java.util.Objects;

/**
 * 二叉树的最小深度 @see https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/submissions/
 *
 * @author Weichao Li (liweichao0102@gmail.com)
 * @since 2019-07-07
 */
public class Solution111 {

    public int minDepth(TreeNode root) {
        return minDepth(root, 0);
    }

    public int minDepth(TreeNode node, int currentDepth) {

        if (node == null) {
            return currentDepth;
        }

        currentDepth++;

        if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
            return currentDepth;
        } else {

            int minDepth = Integer.MAX_VALUE;
            if (node.left != null) {
                minDepth = Math.min(minDepth(node.left, currentDepth), minDepth);
            }
            if (node.right != null) {
                minDepth = Math.min(minDepth(node.right, currentDepth), minDepth);
            }
            return minDepth;
        }

    }
}
