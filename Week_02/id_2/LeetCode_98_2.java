//Given a binary tree, determine if it is a valid binary search tree (BST).
//
// Assume a BST is defined as follows:
//
//
// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
//
//
//
//
// Example 1:
//
//
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
//
//
// Example 2:
//
//
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
//
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

import java.util.ArrayList;
import java.util.List;

public class LeetCode_98_2 {

    /**
     * Hard to think, referenced from solution.
     * @param root
     * @return
     */
    public boolean isValidBSTByTraverse(TreeNode root) {
        return judgeValidBSt(root, null, null);
    }

    public boolean judgeValidBSt(TreeNode cur, TreeNode lower, TreeNode upper) {
        if (cur == null) return true;
        if (lower != null && cur.val <= lower.val) return false;
        if (upper != null && cur.val >= upper.val) return false;
        if (!judgeValidBSt(cur.right, cur, upper)) return false;
        if (!judgeValidBSt(cur.left, lower, cur)) return false;
        return true;
    }

    private List<Integer> list = new ArrayList<>();

    /**
     * Use inOrder traverse, both of time complexity and space complexity is O(n).
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        getListByInOrderTraverse(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1))
                return false;
        }
        return true;
    }

    public void getListByInOrderTraverse(TreeNode root) {
        if (root == null) return;
        getListByInOrderTraverse(root.left);
        list.add(root.val);
        getListByInOrderTraverse(root.right);
    }
}
