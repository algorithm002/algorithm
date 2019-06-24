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

package com.llz.algorithm.algorithm2019.secondweek;

import com.llz.algorithm.algorithm2019.firstweek.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_111_2 {

    /**
     * A clean version referenced from discussion
     *
     * @param root
     * @return
     */
    public int minDepthByTraverseRefact2(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepthByTraverseRefact2(root.left);
        int right = minDepthByTraverseRefact2(root.right);
        return (left == 0 || right == 0) ? (left + right + 1) : Math.min(left, right) + 1;
    }


    /**
     * My refactoring version
     *
     * @param root
     * @return
     */
    public int minDepthByTraverseRefact(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepthByTraverseRefact(root.left);
        int right = minDepthByTraverseRefact(root.right);
        if (left == 0)
            return right + 1;
        else if (right == 0)
            return left + 1;
        else
            return Math.min(left, right) + 1;
    }

    /**
     * Original version
     * Time complexity O(n), space complexity O(n) (worst case)
     * If the given tree is balanced, the time complexity of both time and space is O(logn).
     *
     * @param root
     * @return
     */
    public int minDepthByTraverse(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        else if (root.left == null)
            return minDepthByTraverse(root.right) + 1;
        else if (root.right == null)
            return minDepthByTraverse(root.left) + 1;
        else
            return Math.min(minDepthByTraverse(root.left), minDepthByTraverse(root.right)) + 1;
    }

    /**
     * Use iteration
     * Time complexity O(n), space complexity O(n) (worst case)
     *
     * @param root
     * @return
     */
    public int minDepthByInteration(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.remove();
                if (root.left != null)
                    queue.add(root.left);
                if (root.right != null)
                    queue.add(root.right);
                if (root.left == null && root.right == null) {
                    return depth + 1;
                }
            }
            depth++;
        }
        return depth;
    }

    /**
     * Another easier method for iteration by using sentinel.
     * @param root
     * @return
     */
    public int minDepthByInteration2(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        TreeNode endOfLevel = root;
        while (!queue.isEmpty()) {
            root = queue.remove();
            if (root.left != null)
                queue.add(root.left);
            if (root.right != null)
                queue.add(root.right);
            if (root.left == null && root.right == null) {
                return depth + 1;
            }
            if (root == endOfLevel) {
                endOfLevel = (root.right == null ? root.left : root.right);
                depth++;
            }
        }
        return depth;
    }

}
