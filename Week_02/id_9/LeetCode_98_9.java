package com.github.lifelab.leetcode.problemset;

/**
 * 验证二叉搜索树 @see https://leetcode-cn.com/problems/validate-binary-search-tree/submissions/
 *
 * @author Weichao Li (liweichao0102@gmail.com)
 * @since 2019-06-16
 */
public class Solution98 {

    long temp = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        //terminator
        if (root == null) {
            return true;
        }

        // process
        if (isValidBST(root.left)) {
            if (temp < root.val) {
                temp = root.val;
                //drill down
                return isValidBST(root.right);
            }
        }
        return false;
    }
}
