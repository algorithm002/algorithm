/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
//二叉树  中序遍历  递增
const int_min = ^int(^uint(0) >> 1)

var pre int
var min_diff int

func minDiffInBST(root *TreeNode) int {
	pre = int_min
	min_diff = int(^uint(0) >> 1)
	_dfs(root)
	return min_diff
}

func _dfs(root *TreeNode) {
	if root == nil {
		return
	}
	_dfs(root.Left)
	if pre != int_min && root.Val-pre < min_diff {
		min_diff = root.Val - pre
	}
	pre = root.Val
	_dfs(root.Right)
}