package main

// LeetCode - 024. Swap Nodes in Pairs
// https://leetcode.com/problems/swap-nodes-in-pairs/
func swapPairs(head *ListNode) *ListNode {
	dummy := ListNode{}
	dummy.Next = head

	pre := &dummy

	for pre != nil {
		if pre.Next == nil || pre.Next.Next == nil {
			break
		}

		first := pre.Next
		pre.Next = first.Next
		first.Next = first.Next.Next
		pre.Next.Next = first
		pre = first
	}

	return dummy.Next
}
