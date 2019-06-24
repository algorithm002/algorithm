package com.github.lifelab.leetcode.problemset;

/**
 * 二叉树的最近公共祖先 @https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author Weichao Li (liweichao0102@gmail.com)
 * @since 2019-06-09
 */
public class Solution236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftVal = lowestCommonAncestor(root.left, p, q);

        TreeNode rightVal = lowestCommonAncestor(root.right, p, q);

        if (rightVal != null && leftVal != null) {
            return root;
        }

        if (rightVal != null) {
            return rightVal;
        }

        if (leftVal != null) {
            return leftVal;
        }
        return null;
    }

}
