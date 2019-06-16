package leetcode

func levelOrder(root *TreeNode) [][]int {
	var ret [][]int

	level := 1
	helper(root, level, &ret)

	return ret
}

func helper(root *TreeNode, level int, ret *[][]int) {
	if root == nil {
		return
	}

	if len(*ret) < level {
		*ret = append(*ret, []int{root.Val})
	} else {
		(*ret)[level-1] = append((*ret)[level-1], root.Val)
	}

	helper(root.Left, level+1, ret)
	helper(root.Right, level+1, ret)
}
