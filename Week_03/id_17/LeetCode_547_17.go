/*
 * @lc app=leetcode id=547 lang=golang
 *
 * [547] Friend Circles
 */
func findCircleNum(M [][]int) int {
	memo := make([]int, len(M))
	result := 0
	for i, v := range memo {
		if v == 0 {
			_dfs(memo, M, i)
			result++
		}
	}
	return result
}

func _dfs(memo []int, M [][]int, j int) {
	for i := 0; i < len(M); i++ {
		if memo[i] == 0 && M[i][j] == 1 {
			memo[i] = 1
			_dfs(memo, M, i)
		}
	}
}

