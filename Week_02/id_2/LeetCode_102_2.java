//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
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
//return its level order traversal as:
//
//[
//  [3],
//  [9,20],
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

package com.llz.algorithm.algorithm2019.secondweek;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.llz.algorithm.algorithm2019.firstweek.TreeNode;

public class LeetCode_102_2 {

    /**
     * Time complexity is O(n) and space complexity is O(n) as well.
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.remove();
                list.add(temp.val);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            res.add(list);
        }
        return res;
    }

    /**
     * Time complexity is O(n) and space complexity is O(n) as well.
     * Another dfs solution referenced from discussion.
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderByDfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height == res.size()) res.add(new ArrayList<>());
        res.get(height).add(root.val);
        dfs(res, root.left, height + 1);
        dfs(res, root.right, height + 1);
    }
}
