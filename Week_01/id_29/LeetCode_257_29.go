package main

import "strconv"

// LeetCode - 257. Binary Tree Paths
// https://leetcode.com/problems/binary-tree-paths/
func binaryTreePaths(root *TreeNode) []string {
	if root == nil {
		return nil
	}

	res := make([]string, 0, 16)

	dfs("", root, &res)

	return res
}

func dfs(path string, root *TreeNode, res *[]string) {
	if path == "" {
		path += strconv.Itoa(root.Val)
	} else {
		path += "->" + strconv.Itoa(root.Val)
	}

	if root.Left != nil {
		dfs(path, root.Left, res)
	}
	if root.Right != nil {
		dfs(path, root.Right, res)
	}

	if root.Left == nil && root.Right == nil {
		*res = append(*res, path)
	}
}
