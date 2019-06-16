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

package com.llz.algorithm.algorithm2019.secondweek;

import java.util.*;

import com.llz.algorithm.algorithm2019.firstweek.TreeNode;

public class LeetCode_103_2 {

    /**
     * Original version
     * Time complexity is O(n), space complexity is O(n)
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<TreeNode> innerQueue = new ArrayDeque<>();
        queue.add(root);
        List<Integer> innerList = new ArrayList<>();
        innerList.add(root.val);
        list.add(innerList);

        int size = 0;
        boolean leftToRight = false;
        TreeNode temp = null;
        while (!queue.isEmpty()) {
            size = queue.size();
            innerList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                temp = queue.removeLast();
                if (leftToRight) {
                    if (temp.left != null) {
                        innerQueue.add(temp.left);
                        innerList.add(temp.left.val);
                    }
                    if (temp.right != null) {
                        innerQueue.add(temp.right);
                        innerList.add(temp.right.val);
                    }
                } else {
                    if (temp.right != null) {
                        innerQueue.add(temp.right);
                        innerList.add(temp.right.val);
                    }
                    if (temp.left != null) {
                        innerQueue.add(temp.left);
                        innerList.add(temp.left.val);
                    }
                }
            }
            if (innerList.size() != 0)
                list.add(innerList);
            queue = innerQueue;
            innerQueue = new ArrayDeque<>();
            leftToRight = leftToRight == true ? false : true;
        }
        return list;
    }


    /**
     * A more cleaner and easier code referenced from discussion
     * with only one queue compared with two queues that used by my original version.
     * Remember better utilize JDK API, think about using list.add(index, val) instead of construct an stack.
     * Time complexity is O(n) and space complexity is O(n) as well.
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        boolean leftToRight = false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.remove();
                if (leftToRight)
                    list.add(0, temp.val);
                else
                    list.add(temp.val);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            leftToRight = !leftToRight;
            res.add(list);
            list = new ArrayList<>();
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.right.left = new TreeNode(9);
        root.right.right.left = new TreeNode(10);

        LeetCode_103_2 lc = new LeetCode_103_2();
        List<List<Integer>> list = lc.zigzagLevelOrder2(root);
        System.out.println(list);
    }
}
