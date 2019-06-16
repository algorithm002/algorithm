package main

// LeetCode - 189. Rotate Array
// https://leetcode.com/problems/rotate-array/
func rotate(nums []int, k int) {
	n := len(nums)

	k = k % n

	reverse(nums, 0, n-1)
	reverse(nums, 0, k-1)
	reverse(nums, k, n-1)
}

func reverse(nums []int, i int, j int) {
	for i < j {
		nums[i], nums[j] = nums[j], nums[i]
		i++
		j--
	}
}
