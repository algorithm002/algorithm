package leetcode

func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}

	return ish(root.Left, root.Right)
}

func ish(l, r *TreeNode) bool {
	if l == nil || r == nil {
		return l == r
	}

	if l.Val != r.Val {
		return false
	}

	return ish(l.Left, r.Right) && ish(l.Right, r.Left)
}
