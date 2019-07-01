package leecode

import "bytes"

func solveNQueens(n int) [][]string {
	// 回溯法
	result := make([][]string, 0)
	pie := make([]bool, n*2)
	na := make([]bool, n*2)
	vlines := make([]bool, n)
	qpos := make([]string, n)
	var helper func(level int, qpos []string)
	helper = func(level int, qpos []string) {
		if level == n {
			copystrs := make([]string, len(qpos))
			copy(copystrs, qpos)
			result = append(result, copystrs)
			return
		}
		for i := 0; i < n; i++ {
			if !vlines[i] && !na[i-level+n] && !pie[i+level] {
				vlines[i] = true
				na[i-level+n] = true
				pie[i+level] = true
				s := bytes.Repeat([]byte("."), n)
				s[i] = 'Q'
				qpos[level] = string(s)
				helper(level+1, qpos)
				vlines[i] = false
				na[i-level+n] = false
				pie[i+level] = false
			}
		}
	}
	helper(0, qpos)
	return result
}
