package leecode

func numIslands(grid [][]byte) int {
	count := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == '1' {
				count++
				helper(grid, i, j)
			}
		}
	}
	return count
}

func helper(grid [][]byte, i, j int) {
	m := len(grid)
	n := len(grid[0])
	if i < 0 || j < 0 || i >= m || j >= n {
		return
	}
	if grid[i][j] == '0' {
		return
	}
	grid[i][j] = '0'
	helper(grid, i+1, j)
	helper(grid, i, j+1)
	helper(grid, i-1, j)
	helper(grid, i, j-1)
}
