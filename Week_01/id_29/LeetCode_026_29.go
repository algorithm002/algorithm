package main

// LeetCode - 026. Remove Duplicates from Sorted Array
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
func removeDuplicates(nums []int) int {
	replaceIndex := 1

	for curr := 1; curr < len(nums); curr++ {
		if nums[curr] != nums[curr-1] {
			nums[replaceIndex] = nums[curr]
			replaceIndex++
		}
	}

	return replaceIndex
}
