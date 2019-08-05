package com.llz.algorithm.algorithm2019.firstweek;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * @author liliangzi
 *
 */



public class LeetCode_111_2 {

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.right);


		// 简化代码，用三目运算符
		if (right == 0)
			return left + 1;
		if (left == 0)
			return right + 1;
		return Math.min(left, right) + 1;
	}



}
