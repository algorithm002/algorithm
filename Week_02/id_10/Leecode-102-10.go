/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
//DFS
var result [][]int

func levelOrder(root *TreeNode) [][]int {
	result = [][]int{}
	helper(root, 0)
	return result
}

func helper(root *TreeNode, level int) {
	if root == nil {
		return
	}
	if len(result) <= level {
		result = append(result, []int{})
	}
	result[level] = append(result[level], root.Val)
	helper(root.Left, level+1)
	helper(root.Right, level+1)
}

//BFS
func levelOrder2(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	result := make([][]int, 0)
	nodes := []*TreeNode{root}
	for len(nodes) > 0 {
		result = append(result, []int{})
		newnodes := make([]*TreeNode, 0)
		for i := 0; i < len(nodes); i++ {
			node := nodes[i]
			result[len(result)-1] = append(result[len(result)-1], node.Val)
			if node.Left != nil {
				newnodes = append(newnodes, node.Left)
			}
			if node.Right != nil {
				newnodes = append(newnodes, node.Right)
			}
		}
		nodes = newnodes
	}
	return result
}