//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
//
// Given the following binary tree: root = [3,5,1,6,2,0,8,null,null,7,4]
//
//
//
// Example 1:
//
//
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//Output: 3
//Explanation: The LCA of nodes 5 and 1 is 3.
//
//
// Example 2:
//
//
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//Output: 5
//Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
//
//
//
//
// Note:
//
//
// All of the nodes' values will be unique.
// p and q are different and both values will exist in the binary tree.
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

import java.util.*;

public class LeetCode_236_2 {

    /**
     * Time complexity is O(n), space complexity is O(n).
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorByIteration(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
        map.put(root, null);
        queue.add(root);
        int find = 2;
        while (!queue.isEmpty() && find != 0) {
            root = queue.remove();
            if (root == p)
                find--;
            if (root == q)
                find--;
            if (root.left != null) {
                map.put(root.left, root);
                queue.add(root.left);
            }
            if (root.right != null) {
                map.put(root.right, root);
                queue.add(root.right);
            }
        }

        List<TreeNode> list = new ArrayList<>();
        TreeNode temp = q;
        while (q != null) {
            list.add(q);
            q = map.get(q);
        }

        while (!list.contains(p)) {
            p = map.get(p);
        }
        return p;
    }

    private TreeNode lca = null;

    /**
     * Time complexity is O(n), space complexity is O(n).
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca = null;
        dfs(root, p, q);
        return lca;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        int left = dfs(root.left, p, q) ? 1 : 0;
        int right = dfs(root.right, p, q) ? 1 : 0;
        int mid = 0;
        if (p == root | q == root) {
            mid = 1;
        }
        if (left + mid + right >= 2)
            lca = root;
        return (left + right + mid) > 0;
    }

    public static void test1() {
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        root.left = p;
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        TreeNode q = new TreeNode(4);
        root.left.right.right = q;
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        LeetCode_236_2 lca = new LeetCode_236_2();
        TreeNode lc = lca.lowestCommonAncestor(root, p, q);
        System.out.println(lc.val);
    }

    public static void main(String[] args) {
        test1();
    }
}
