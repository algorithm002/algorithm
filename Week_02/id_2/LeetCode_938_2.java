//Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
//
// The binary search tree is guaranteed to have unique values.
//
//
//
//
// Example 1:
//
//
//Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
//Output: 32
//
//
//
// Example 2:
//
//
//Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
//Output: 23
//
//
//
//
// Note:
//
//
// The number of nodes in the tree is at most 10000.
// The final answer is guaranteed to be less than 2^31.
//
//
//

package com.llz.algorithm.algorithm2019.secondweek;

import com.llz.algorithm.algorithm2019.firstweek.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode_938_2 {

    private int sum = 0;

    public int rangeSumBSTByTraverse(TreeNode root, int L, int R) {
        dfs(root, L, R);
        return sum;
    }

    /**
     * There is time cost difference depends on how you deal with the case of null root.
     * If you write "if (root == null) return;",then the function will backtrack
     * and cost more time than if you just eliminate the "root equals null" situation by writing
     * "if (root != null) {...} ".
     * Time complexity is O(n) and space complexity is O(h)(h is height of BST).
     * If the given BST is balanced, then the time complexity is O(logn) and space complexity is O(logn) as well.
     *
     * @param root
     * @param L
     * @param R
     */
    public void dfs(TreeNode root, int L, int R) {
        if (root != null) {
            if (root.val >= L && root.val <= R)
                sum += root.val;
            if (root.val > L) dfs(root.left, L, R);
            if (root.val < R) dfs(root.right, L, R);
        }
    }

    /**
     *  Use stack to record the possible target nodes.
     *  Time complexity is O(n) and space complexity is O(h)(h is height of BST).
     *  If the given BST is balanced, then the time complexity is O(logn) and space complexity is O(logn) as well.
     * @param root
     * @param L
     * @param R
     * @return
     */
    public int rangeSumBSTByIteration(TreeNode root, int L, int R) {
        if (root == null) return 0;
        int sum = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.val >= L && root.val <= R)
                sum += root.val;
            if (root.val > L && null != root.left) stack.push(root.left);
            if (root.val < R && null != root.right) stack.push(root.right);
        }
        return sum;
    }

}
