package com.llz.algorithm.algorithm2019.firstweek;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * @author liliangzi
 *
 */
public class LeetCode_104_2 {

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
	}

	public static void main(String[] args) {

	}

}
