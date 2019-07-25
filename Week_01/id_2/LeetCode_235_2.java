package com.llz.algorithm.algorithm2019.firstweek;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree, find the lowest common ancestor (LCA) of two
 * given nodes in the bst.
 *
 * @author liliangzi
 *
 *
 *         Definition for a binary tree node. public class TreeNode { int val;
 *         TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class LeetCode_235_2 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> pAncestors = new ArrayList<TreeNode>();
		List<TreeNode> qAncestors = new ArrayList<TreeNode>();
		pAncestors.add(root);
		qAncestors.add(root);
		getAncestors(root, p, pAncestors);
		getAncestors(root, q, qAncestors);
		TreeNode lca = null;
		for (int i = pAncestors.size() - 1; i >= 0; i--) {
			lca = pAncestors.get(i);
			if (qAncestors.contains(lca)) {
				return lca;
			}
		}
		return null;
	}

	public TreeNode lowestCommonAncestorByIteration(TreeNode root, TreeNode p, TreeNode q) {
		while (root != null && root.val != p.val && root.val != q.val) {
			if (p.val <= root.val && q.val <= root.val)
				root = root.left;
			else if (p.val >= root.val && q.val >= root.val)
				root = root.right;
			else
				return root;
		}
		return root;
	}

	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

		// Chao: 如果有相应的return在if语句里的时候，建议能直接不需要else的分支。

		if (root.val == p.val || root.val == q.val)
			return root;
		if ((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val)) {
			return root;
		} else {
			if (root.left != null && p.val <= root.val && q.val <= root.val) {
				return lowestCommonAncestor2(root.left, p, q);
			}
			if (root.right != null && p.val >= root.val && q.val >= root.val) {
				return lowestCommonAncestor2(root.right, p, q);
			}
		}
		return root;
	}

	public void getAncestors(TreeNode root, TreeNode node, List<TreeNode> ancestors) {
		if (root == node) {
			return;
		} else {
			if (root.left != null && node.val < root.val) {
				ancestors.add(root.left);
				getAncestors(root.left, node, ancestors);
			}
			if (root.right != null && node.val > root.val) {
				ancestors.add(root.right);
				getAncestors(root.right, node, ancestors);
			}
		}
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
		LeetCode_235_2 lca = new LeetCode_235_2();
		TreeNode lc = lca.lowestCommonAncestor2(root, p, q);
		System.out.println(lc.val);
	}

}
