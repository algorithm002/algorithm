import (
	"sort"
)

/*
 * @lc app=leetcode id=15 lang=golang
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (24.03%)
 * Likes:    3806
 * Dislikes: 425
 * Total Accepted:    555.7K
 * Total Submissions: 2.3M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 *
 *
 */
func threeSum(nums []int) [][]int {
	sort.Ints(nums)
	var res [][]int

	for i1 := 0; i1 < len(nums)-2; i1++ {
		if i1 > 0 && nums[i1] == nums[i1-1] {
			continue
		}
		left := i1 + 1
		right := len(nums) - 1
		for left < right {
			// fmt.Println(nums[i1], nums[left], nums[right])
			tmpsum := nums[i1] + nums[left] + nums[right]
			if tmpsum == 0 {
				res = append(res, []int{nums[i1], nums[left], nums[right]})

				for left < right && nums[left] == nums[left+1] {
					left++
				}
				for left < right && nums[right] == nums[right-1] {
					right--
				}
				left++
				right--
			} else if tmpsum > 0 {
				right--
			} else if tmpsum < 0 {
				left++
			}
		}
	}
	return res
}

