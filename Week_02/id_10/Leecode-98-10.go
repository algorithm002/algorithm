/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var pre int

func isValidBST(root *TreeNode) bool {
	if root == nil {
		return true
	}
	// int类型的最小值
	pre = ^int(^uint(0) >> 1)
	return _dfs(root)
}

//二叉搜索树 中序遍历  递增序列
func _dfs(root *TreeNode) bool {
	if root == nil {
		return true
	}
	if !_dfs(root.Left) {
		return false
	}
	curVal := root.Val
	if curVal <= pre {
		return false
	}
	pre = curVal
	if !_dfs(root.Right) {
		return false
	}
	return true
}