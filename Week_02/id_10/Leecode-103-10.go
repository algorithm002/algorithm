/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func zigzagLevelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	nodes := []*TreeNode{root}
	result := make([][]int, 0)
	reversed := true
	for len(nodes) > 0 {
		newnodes := make([]*TreeNode, 0)
		result = append(result, []int{})
		for i := 0; i < len(nodes); i++ {
			node := nodes[i]
			result[len(result)-1] = append(result[len(result)-1], node.Val)
		}
		for i := len(nodes) - 1; i >= 0; i-- {
			node := nodes[i]
			if reversed {
				if node.Right != nil {
					newnodes = append(newnodes, node.Right)
				}
				if node.Left != nil {
					newnodes = append(newnodes, node.Left)
				}
			} else {
				if node.Left != nil {
					newnodes = append(newnodes, node.Left)
				}
				if node.Right != nil {
					newnodes = append(newnodes, node.Right)
				}
			}
		}
		nodes = newnodes
		reversed = !reversed
	}
	return result
}