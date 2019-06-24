package leetcode

func isValidBST(root *TreeNode) bool {
	return rec(root, nil, nil)
}

func rec(node *TreeNode, min, max *int) bool {
	if node == nil {
		return true
	}

	if min != nil && node.Val <= *min || max != nil && node.Val >= *max {
		return false
	}

	return rec(node.Left, min, &node.Val) && rec(node.Right, &node.Val, max)
}
