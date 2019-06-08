package main

// LeetCode - 104. Maximum Depth of Binary Tree
// https://leetcode.com/problems/maximum-depth-of-binary-tree/
import "math"

func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}

	return int(math.Max(float64(maxDepth(root.Left)), float64(maxDepth(root.Right))) + 1)
}
