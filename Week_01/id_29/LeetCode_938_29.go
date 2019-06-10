package main

// LeetCode - 938. Range Sum of BST
// https://leetcode.com/problems/range-sum-of-bst/
func rangeSumBST(root *TreeNode, L int, R int) int {
	return dfs938(root, L, R)
}

func dfs938(root *TreeNode, L int, R int) int {
	if root == nil {
		return 0
	}

	if root.Val >= L && root.Val <= R {
		return root.Val + dfs938(root.Left, L, R) + dfs938(root.Right, L, R)
	}

	return dfs938(root.Left, L, R) + dfs938(root.Right, L, R)
}
