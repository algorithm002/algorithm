import "strconv"

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var allroutes []string

func binaryTreePaths(root *TreeNode) []string {
	if root == nil {
		return []string{}
	}
	allroutes = make([]string, 0)
	dfs("", root)
	return allroutes
}

func dfs(str string, root *TreeNode) {
	curroute := ""
	if str == "" {
		curroute = strconv.Itoa(root.Val)
	} else {
		curroute = str + "->" + strconv.Itoa(root.Val)
	}
	if root.Left == nil && root.Right == nil {
		allroutes = append(allroutes, curroute)
		return
	}
	if root.Left != nil {
		dfs(curroute, root.Left)
	}
	if root.Right != nil {
		dfs(curroute, root.Right)
	}
}
