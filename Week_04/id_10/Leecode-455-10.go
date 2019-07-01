package leecode

import "sort"

func findContentChildren(g []int, s []int) int {
	//贪心算法  饼干最大 配胃口最大的孩子
	sort.Ints(g)
	sort.Ints(s)
	gi := len(g) - 1
	si := len(s) - 1
	count := 0
	for gi >= 0 && si >= 0 {
		if g[gi] <= s[si] {
			si--
			count++
		}
		gi--
	}
	return count
}
