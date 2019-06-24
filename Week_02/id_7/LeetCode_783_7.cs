/*
 * @lc app=leetcode.cn id=783 lang=csharp
 *
 * [783] 二叉搜索树结点最小距离
 */

using System;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int m_nRsult = int.MaxValue;
    int m_nLastv = -999999;
    public int MinDiffInBST (TreeNode root) {
        if (root.left != null)
            MinDiffInBST (root.left);
        m_nRsult = Math.Min (m_nRsult, root.val - m_nLastv);
        m_nLastv = root.val;
        if (root.right != null)
            MinDiffInBST (root.right);

        return m_nRsult;
    }
}