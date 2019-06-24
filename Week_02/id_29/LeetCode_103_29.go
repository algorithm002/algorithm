package leetcode

func zigzagLevelOrder(root *TreeNode) [][]int {
	var result [][]int

	vector := 1
	stack := []*TreeNode{root}

	for len(stack) > 0 {
		var tmp []*TreeNode
		var levelVal []int
		for i := len(stack) - 1; i >= 0; i-- {
			node := stack[i]
			if node == nil {
				continue
			}
			if vector == 1 {
				tmp = append(tmp, node.Left, node.Right)
			} else {
				tmp = append(tmp, node.Right, node.Left)
			}
			levelVal = append(levelVal, node.Val)
		}
		vector = -vector
		stack = tmp
		if len(levelVal) > 0 {
			result = append(result, levelVal)
		}
	}

	return result
}
