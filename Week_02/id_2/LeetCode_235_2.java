package com.llz.algorithm.algorithm2019.secondweek;

import com.llz.algorithm.algorithm2019.firstweek.TreeNode;

//Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
//
// Given binary search tree: root = [6,2,8,0,4,7,9,null,null,3,5]
//
//
//
// Example 1:
//
//
//Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//Output: 6
//Explanation: The LCA of nodes 2 and 8 is 6.
//
//
// Example 2:
//
//
//Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//Output: 2
//Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
//
//
//
//
// Note:
//
//
// All of the nodes' values will be unique.
// p and q are different and both values will exist in the BST.
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

public class LeetCode_235_2 {

    private TreeNode lca = null;

    /**
     * For all the traverse methods regarding this solution, the time complexity is O(n) and space complexity
     * is O(n) as we use stack for recursion.
     * If the given BST is a balanced tree, the time complexity would be O(logn).
     * @param root
     * @param p
     * @param q
     * @return 
     */
    public TreeNode lowestCommonAncestorByTraverse1(TreeNode root, TreeNode p, TreeNode q) {
        getLowestCommonAncestor(root, p, q);
        return lca;
    }

    public void getLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return;
        if (p.val < root.val && q.val < root.val)
            getLowestCommonAncestor(root.left, p, q);
        else if (p.val > root.val && q.val > root.val)
            getLowestCommonAncestor(root.right, p, q);
        else
            lca = root;
    }

    /**
     * Another traverse method without create an Object just return the result
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorByTraverse2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestorByTraverse2(root.left, p, q);
        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestorByTraverse2(root.right, p, q);
        else
            return root;
    }

    /**
     * Time complexity is O(n) and space complexity is O(1)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorByIteraton(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val)
                root = root.left;
            else if (p.val > root.val && q.val > root.val)
                root = root.right;
            else
                break;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode p = new TreeNode(2);
        root.left = p;
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        TreeNode q = new TreeNode(5);
        root.left.right.right = q;
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        LeetCode_235_2 lc1 = new LeetCode_235_2();
        TreeNode lc = lc1.lowestCommonAncestorByTraverse2(root, p, q);
        System.out.println(lc.val);
    }
}
