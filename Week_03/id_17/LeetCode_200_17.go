/*
 * @lc app=leetcode id=200 lang=golang
 *
 * [200] Number of Islands
 */
func numIslands(grid [][]byte) int {
	result := 0
	for i, v1 := range grid {
		for j, v2 := range v1 {
			if v2 == '1' {
				sink(i, j, grid)
				result++
			}
		}
	}
	return result
}

func sink(x, y int, grid [][]byte) {
	xlength := len(grid)
	ylength := len(grid[0])
	if x < 0 || y < 0 || x >= xlength || y >= ylength || grid[x][y] != '1' {
		return
	}
	grid[x][y] = '0'
	sink(x-1, y, grid)
	sink(x, y-1, grid)
	sink(x+1, y, grid)
	sink(x, y+1, grid)
}


