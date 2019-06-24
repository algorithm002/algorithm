package leecode

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var mindepth int

func minDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	const MAXINT = int(^uint(0) >> 1)
	mindepth = MAXINT
	dfs(root, 1)
	return mindepth
}

func dfs(root *TreeNode, level int) {
	if root.Left == nil && root.Right == nil {
		if level < mindepth {
			mindepth = level
		}
		return
	}
	if level >= mindepth {
		return
	}
	if root.Left != nil {
		dfs(root.Left, level+1)
	}
	if root.Right != nil {
		dfs(root.Right, level+1)
	}
}
