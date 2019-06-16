package main

// LeetCode - 021. Merge Two Sorted Lists
// https://leetcode.com/problems/merge-two-sorted-lists/
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	// Check boundary condition
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}

	// Create dummy node
	dummy := ListNode{}
	head := &dummy

	// Connect l1 and l2
	for l1 != nil && l2 != nil {
		if l1.Val < l2.Val {
			head.Next = l1
			l1 = l1.Next
		} else {
			head.Next = l2
			l2 = l2.Next
		}
		head = head.Next
	}

	// Check leftover
	if l1 != nil {
		head.Next = l1
	}
	if l2 != nil {
		head.Next = l2
	}

	return dummy.Next
}
