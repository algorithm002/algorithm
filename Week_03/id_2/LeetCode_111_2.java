//Given a binary tree, find its minimum depth.
//
// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//
// Note: A leaf is a node with no children.
//
// Example:
//
// Given binary tree [3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
// return its minimum depth = 2.
//

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

package com.llz.algorithm.algorithm2019.thirdweek;

import apple.laf.JRSUIUtils;
import com.llz.algorithm.algorithm2019.firstweek.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode_111_2 {

    /**
     * Time complexity O(n), space complexity O(n) (worst case)
     * If the given tree is balanced, the time complexity of both time and space is O(logn).
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null)
            return right + 1;
        if (root.right == null)
            return left + 1;
        return Math.min(left, right) + 1;
    }


    /**
     * Time complexity O(n), space complexity O(n) (worst case)
     * If the given tree is balanced, the time complexity of both time and space is O(logn).
     *
     * @param root
     * @return
     */

    public int minDepthByIteration(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (cur.left == null && cur.right == null) {
                    depth++;
                    return depth;
                }
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            depth++;
        }
        return depth;
    }
}
