//Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
//
// Example :
//
//
//Input: root = [4,2,6,1,3,null,null]
//Output: 1
//Explanation:
//Note that root is a TreeNode object, not an array.
//
//The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
//
//          4
//        /   \
//      2      6
//     / \
//    1   3
//
//while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
//
//
// Note:
//
//
// The size of the BST will be between 2 and 100.
// The BST is always valid, each node's value is an integer, and each node's value is different.
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

public class LeetCode_783_2 {


    /**
     * Using brutal force, calculate distance between any two separate nodes in BST
     * and acquire the minDistance.
     * Time complexity is O(n^2), space complexity is O(n).
     *
     * @param root
     * @return
     */
    public int minDiffInBSTByBF(TreeNode root) {
        int minDistByBF = Integer.MAX_VALUE;
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++)
                if (Math.abs(list.get(j).val - list.get(i).val) < minDistByBF)
                    minDistByBF = Math.abs(list.get(j).val - list.get(i).val);

        }
        return minDistByBF;
    }

    public void inOrder(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }

    private int minDist = Integer.MAX_VALUE;
    private TreeNode pre = null;

    /**
     * Using InOrderTraverse, the time complexity is O(n) as well as space complexity.
     *
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        if (root.left != null) minDiffInBST(root.left);
        if (pre != null) minDist = Math.min(root.val - pre.val, minDist);
        pre = root;
        if (root.right != null) minDiffInBST(root.right);
        return minDist;
    }
}
