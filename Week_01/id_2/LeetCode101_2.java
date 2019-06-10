package com.llz.algorithm.algorithm2019.firstweek;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

import java.util.LinkedList;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * @author liliangzi
 *
 */
public class LeetCode101_2 {

	/**
	 * can't pass [1,2,2,null,3,null,3] Use iteration (level order traverse) to
	 * judge where the given tree is symmetric.
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSymmetricNeedToCorrect(TreeNode root) {
		if (root == null)
			return false;
		Deque<TreeNode> stack = new ArrayDeque<>();
		Deque<TreeNode> innerStack = new ArrayDeque<>();
		stack.push(root);
		while (true) {
			if (stack.isEmpty())
				break;
			while (!stack.isEmpty()) {
				TreeNode cur = stack.pop();
				if (cur.left != null)
					innerStack.add(cur.left);
				if (cur.right != null)
					innerStack.add(cur.right);
			}
			if (innerStack.size() % 2 != 0)
				return false;
			while (!innerStack.isEmpty()) {
				if (innerStack.peekFirst().val != innerStack.peekLast().val)
					return false;
				else {
					stack.addFirst(innerStack.removeFirst());
					stack.addLast(innerStack.removeLast());
				}
			}
		}
		return true;
	}


	/**
	 * Have referenced from solution
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSymmetricByIteration(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			TreeNode mirrCur = queue.poll();
			if (cur == null && mirrCur == null)
				continue;
			if (cur == null || mirrCur == null)
				return false;
			if (cur.val != mirrCur.val)
				return false;
			queue.add(cur.left);
			queue.add(mirrCur.right);
			queue.add(cur.right);
			queue.add(mirrCur.left);
		}
		return true;
	}

	/**
	 * Use traverse to judge whether the tree is symmetric
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return false;
		return isSymmetricByTraverse(root.left, root.right);
	}

	public boolean isSymmetricByTraverse(TreeNode cur, TreeNode mirrCur) {
		if (cur == null || mirrCur == null) {
			if (mirrCur != null || cur != null)
				return false;
			else
				return true;
		}
		return (cur.val == mirrCur.val) && isSymmetricByTraverse(cur.left, mirrCur.right)
				&& isSymmetricByTraverse(cur.right, mirrCur.left);
	}

	public static void test1() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		LeetCode101_2 s = new LeetCode101_2();
		System.out.println(s.isSymmetric(root));
	}

	public static void test2() {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(5);
		LeetCode101_2 s = new LeetCode101_2();
		System.out.println(s.isSymmetric(root));
	}

	public static void main(String[] args) {
		test2();
	}

}
