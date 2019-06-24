package com.llz.algorithm.algorithm2019.firstweek;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * 
 */

public class LeetCode_236_2 {

	private TreeNode lca;

	public LeetCode_236_2() {
		this.lca = null;
	}

	/**
	 * Have referenced from solution (use iteration). The thought is as similar as
	 * myNeedRefact method but more efficient.
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestorByIteration(TreeNode root, TreeNode p, TreeNode q) {
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		Map<TreeNode, TreeNode> parentMap = new HashMap<TreeNode, TreeNode>();
		parentMap.put(root, null);
		stack.push(root);
		
		while (!((parentMap.containsKey(p)) && (parentMap.containsKey(q)))) {
			if (stack.isEmpty())
				break;
			TreeNode cur = stack.pop();
			if (cur.left != null) {
				parentMap.put(cur.left, cur);
				stack.push(cur.left);
			}
			if (cur.right != null) {
				parentMap.put(cur.right, cur);
				stack.push(cur.right);
			}
		}
		
		Set<TreeNode> pAncestors = new HashSet<TreeNode>();
		
		while ( p!=null ) {
			pAncestors.add(p);
			p = parentMap.get(p);
		}
		
		while ( !pAncestors.contains(q)) {
			q = parentMap.get(q);
		}
		return q;
	}

	/**
	 * Have refereced from solution (use Backtrack)
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		traverse(root, p, q);

		return this.lca;
	}

	public boolean traverse(TreeNode currentNode, TreeNode p, TreeNode q) {
		if (currentNode == null) {
			return false;
		}
		int left = traverse(currentNode.left, p, q) ? 1 : 0;
		int right = traverse(currentNode.right, p, q) ? 1 : 0;
		int mid = ((currentNode == p) || (currentNode == q)) ? 1 : 0;
		if (left + right + mid >= 2)
			this.lca = currentNode;
		return (left + right + mid) > 0;

	}

	/**
	 * Time limit exceed.
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestorNeedToRefact(TreeNode root, TreeNode p, TreeNode q) {
		Map<TreeNode, TreeNode> pAncestors = new HashMap<TreeNode, TreeNode>();
		Map<TreeNode, TreeNode> qAncestors = new HashMap<TreeNode, TreeNode>();
		pAncestors.put(root, null);
		getLowestCommonAncestorByTraverseNeedToRefact(root, p, pAncestors);
		getLowestCommonAncestorByTraverseNeedToRefact(root, q, qAncestors);
		TreeNode lca = p;
		TreeNode qAncestor = q;
		while (lca != root) {
			while (qAncestors.get(qAncestor) != root) {
				if (qAncestors.get(qAncestor) == lca)
					return lca;
				qAncestor = qAncestors.get(qAncestor);
			}
			lca = pAncestors.get(lca);
		}
		return root;
	}

	/**
	 * Time limit exceed
	 * 
	 * @param root
	 * @param targetNode
	 * @param map
	 */
	public void getLowestCommonAncestorByTraverseNeedToRefact(TreeNode root, TreeNode targetNode,
			Map<TreeNode, TreeNode> map) {
		if (root == targetNode) {
			return;
		}
		if (root.left != null) {
			map.put(root.left, root);
			getLowestCommonAncestorByTraverseNeedToRefact(root.left, targetNode, map);
		}
		if (root.right != null) {
			map.put(root.right, root);
			getLowestCommonAncestorByTraverseNeedToRefact(root.right, targetNode, map);
		}

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
		TreeNode lc = lca.lowestCommonAncestorByIteration(root, p, q);
		System.out.println(lc.val);
	}

	public static void test2() {
		TreeNode root = new TreeNode(1);
		TreeNode p = root;
		TreeNode q = new TreeNode(2);
		LeetCode_236_2 lca = new LeetCode_236_2();
		TreeNode lc = lca.lowestCommonAncestorByIteration(root, p, q);
		System.out.println(lc.val);
	}

	public static void main(String[] args) {
		test1();
		test2();
	}

}
