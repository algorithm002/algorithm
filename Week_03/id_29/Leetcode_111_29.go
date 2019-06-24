package main

func minDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	left := minDepth(root.Left)
	right := minDepth(root.Right)
	if left == 0 || right == 0 {
		return 1 + max(left, right)
	}
	return 1 + min(left, right)
}

func min(x, y int) int {
	if x >= y {
		return y
	} else {
		return x
	}
}

func max(x, y int) int {
	if x <= y {
		return y
	} else {
		return x
	}
}
