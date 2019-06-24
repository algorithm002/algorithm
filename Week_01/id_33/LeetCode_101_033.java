/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSym(root, root);
    }

    public boolean isSym(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode == null && rightNode == null)
            return true;
        if(leftNode == null || rightNode == null || leftNode.val != rightNode.val)
            return false;
        return isSym(leftNode.left, rightNode.right) && isSym(leftNode.right, rightNode.left);
    }
}

