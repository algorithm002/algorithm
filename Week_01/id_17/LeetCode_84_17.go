/*
 * @lc app=leetcode id=84 lang=golang
 *
 * [84] Largest Rectangle in Histogram
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (31.15%)
 * Likes:    1874
 * Dislikes: 50
 * Total Accepted:    174.6K
 * Total Submissions: 560.4K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 *
 *
 *
 *
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 *
 *
 *
 *
 * The largest rectangle is shown in the shaded area, which has area = 10
 * unit.
 *
 *
 *
 * Example:
 *
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 *
 *
 */
func largestRectangleArea(heights []int) int {
	var newstack = []int{0}
	var posstack = []int{0}
	heights = append(heights, 0)
	maxarea := 0
	for i, v := range heights {
		for l := len(newstack); newstack[l-1] > v; l = len(newstack) {
			tmpheight := newstack[l-1]
			left := posstack[l-2]
			right := i
			maxarea = max((right-left)*tmpheight, maxarea)
			posstack = posstack[:l-1]
			newstack = newstack[:l-1]
		}
		newstack = append(newstack, v)
		posstack = append(posstack, i+1)
	}
	return maxarea
}
func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}


