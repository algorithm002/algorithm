package main

// LeetCode - 088. Merge Sorted Array
// https://leetcode.com/problems/merge-sorted-array/
func merge(nums1 []int, m int, nums2 []int, n int) {
	replaceIndex := m + n - 1
	array1Target := m - 1
	array2Target := n - 1

	for array2Target >= 0 {
		if array1Target >= 0 && nums2[array2Target] < nums1[array1Target] {
			nums1[replaceIndex] = nums1[array1Target]
			array1Target--
		} else {
			nums1[replaceIndex] = nums2[array2Target]
			array2Target--
		}
		replaceIndex--
	}
}
