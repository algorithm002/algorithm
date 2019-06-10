package main

import (
	"sort"
	"strings"
)

// LeetCode - 49. Group Anagrams
// https://leetcode.com/problems/group-anagrams/
func SortString(w string) string {
	s := strings.Split(w, "")
	sort.Strings(s)
	return strings.Join(s, "")
}

func groupAnagrams(strs []string) [][]string {
	m := make(map[string][]string)

	for _, w := range strs {
		word := SortString(w)
		m[word] = append(m[word], w)
	}

	var ss [][]string
	for e := range m {
		ss = append(ss, m[e])
	}
	return ss
}
