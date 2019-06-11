package com.llz.algorithm.algorithm2019.secondweek;

import com.llz.algorithm.algorithm2019.firstweek.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
// For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// But the following [1,2,2,null,3,null,3] is not:
//
//
//    1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// Note:
//Bonus points if you could solve it both recursively and iteratively.
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

public class LeetCode101_2 {

    /**
     * Time and space complexity is O(n), n is the number of nodes in the tree.
     * @param root
     * @return
     */
    public boolean isSymmetricByTraverse(TreeNode root) {
        return traverse(root, root);
    }

    public boolean traverse(TreeNode cur, TreeNode mirr) {
        if (cur == null && mirr == null)
            return true;
        if (cur == null || mirr == null) {
            return false;
        }
        if (cur.val != mirr.val)
            return false;
        return traverse(cur.left, mirr.right) && traverse(cur.right, mirr.left);

    }

    /**
     * Time and space complexity is O(n), n is the number of nodes in the tree.
     * However, traverse method is faster than the iteration method. I think it owns to
     * the cost of creation and the operation of the deque.
     * @param root
     * @return
     */
    public boolean isSymmetricByIteration(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        deque.add(root);
        TreeNode cur, mirr;
        while (!deque.isEmpty()) {
            cur = deque.poll();
            mirr = deque.poll();
            if (cur == null && mirr == null) continue;
            if (cur == null || mirr == null) return false;
            if (cur.val != mirr.val) return false;
            deque.add(cur.left);
            deque.add(mirr.right);
            deque.add(cur.right);
            deque.add(mirr.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        LeetCode101_2 s = new LeetCode101_2();
        System.out.println(new LeetCode101_2().isSymmetricByTraverse(root));
    }
}
