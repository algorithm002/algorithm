/*
 * @lc app=leetcode.cn id=101 lang=csharp
 *
 * [101] 对称二叉树
 */

using System.Collections;
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
    // 按层遍历，按顺序：左子树左节点、右子树右节点、左子树右节点、右子树左节点，进队列，然后每次出队列两个，比较是否相等，遇不等就直接返回false
    public bool IsSymmetric (TreeNode root) {
        Queue que = new Queue ();
        que.Enqueue (root);
        que.Enqueue (root);
        while (que.Count > 0) {
            TreeNode nodeL = (TreeNode) que.Dequeue ();
            TreeNode nodeR = (TreeNode) que.Dequeue ();
            if (nodeL == null && nodeR == null)
                continue;
            if (nodeL == null || nodeR == null)
                return false;
            if (nodeL.val != nodeR.val)
                return false;
            que.Enqueue (nodeL.left);
            que.Enqueue (nodeR.right);
            que.Enqueue (nodeL.right);
            que.Enqueue (nodeR.left);
        }
        return true;
    }
}