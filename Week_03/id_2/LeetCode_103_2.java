//Given a binary tree, return the zigzag level order traversal of its nodes' values.
// (ie, from left to right, then right to left for the next level and alternate between).
//
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
//
//return its zigzag level order traversal as:
//
//[
//  [3],
//  [20,9],
//  [15,7]
//]
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

package com.llz.algorithm.algorithm2019.thirdweek;

import com.llz.algorithm.algorithm2019.firstweek.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCode_103_2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean isLeftToRight = true;
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> innerList = new ArrayList<>();
            for (int i = 0; i < innerList.size(); i++) {
                TreeNode cur = queue.remove();
                if (isLeftToRight) {
                    innerList.add(cur.val);
                } else {
                    innerList.add(0, cur.val);
                }
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            list.add(innerList);
            isLeftToRight = !isLeftToRight;
        }
        return list;
    }
}
