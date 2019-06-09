package com.llz.algorithm.algorithm2019.firstweek;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_783_2 {

	/**
	 * Brutal force
	 * Haven't considered the given tree is BST.
	 * @param root
	 * @return
	 */
	public int minDiffInBSTByBF(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		int minDist = root.val;
		dfs(root, list);
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (Math.abs(list.get(i) - list.get(j)) < minDist)
					minDist = Math.abs(list.get(i) - list.get(j));
			}
		}
		return minDist;
	}

	public void dfs(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		if (list.contains(root.val))
			return;
		list.add(root.val);
		dfs(root.left, list);
		dfs(root.right, list);
	}

	Integer res = Integer.MAX_VALUE, pre = null;

	public int minDiffInBST(TreeNode root) {
		if (root.left != null)
			minDiffInBST(root.left);
		if (pre != null)
			res = Math.min(res, root.val - pre);
		pre = root.val;
		if (root.right != null)
			minDiffInBST(root.right);
		return res;
	}

	public static void test() {
		LeetCode_783_2 m = new LeetCode_783_2();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		System.out.println(m.minDiffInBST(root));
	}

	public static void main(String[] args) {
		test();
	}

}
