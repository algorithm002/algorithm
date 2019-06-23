/*
 * @lc app=leetcode.cn id=111 lang=csharp
 *
 * [111] 二叉树的最小深度
 */

using System;
using System.Collections;
using System.Collections.Generic;
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
    // 深度优先遍历所有节点，最后输出最小深度（非递归实现）
    public int MinDepth (TreeNode root) {
        Stack sk = new Stack ();
        if (root == null) {
            return 0;
        } else {
            sk.Push (new KeyValuePair<TreeNode, int> (root, 1));
        }
        int nDepth = int.MaxValue;
        while (sk.Count > 0) {
            KeyValuePair<TreeNode, int> kvp = (KeyValuePair<TreeNode, int>) sk.Pop ();
            root = kvp.Key;
            int nTemp = kvp.Value;
            if (root.left == null && root.right == null) {
                nDepth = Math.Min (nDepth, nTemp);
            }
            if (root.left != null) {
                sk.Push (new KeyValuePair<TreeNode, int> (root.left, nTemp + 1));
            }
            if (root.right != null) {
                sk.Push (new KeyValuePair<TreeNode, int> (root.right, nTemp + 1));
            }
        }
        return nDepth;
    }
}