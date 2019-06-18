/*
 * @lc app=leetcode id=3 lang=golang
 *
 * [3] Longest Substring Without Repeating Characters
 */
func lengthOfLongestSubstring(s string) int {
	length := len(s)
	if length == 0 {
		return 0
	}
	m := make(map[byte]int)
	cur := 0
	result := 0
	startPos := 0
	endPos := 0
	for i := 0; i < length; i++ {
		elem, ok := m[s[i]]
		if ok {
			startPos = maxof(elem+1, startPos)
			endPos = i
		} else {
			endPos = i
		}
		m[s[i]] = i
		cur = endPos - startPos + 1
		result = maxof(cur, result)
	}
	return result
}

func maxof(x, y int) int {
	if x > y {
		return x
	}
	return y
}
