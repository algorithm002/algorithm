package leetcode

import "strings"

func lengthOfLongestSubstring(s string) int {
	maxLength := 0
	right := 0
	curr := ""

	for right < len(s) {
		char := string(s[right])
		if !strings.Contains(curr, char) {
			curr += char
			if len(curr) > maxLength {
				maxLength = len(curr)
			}
			right++
		} else {
			curr = curr[1:]
		}
	}

	return maxLength
}
