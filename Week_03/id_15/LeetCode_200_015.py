class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        num_islands = 0
    
        for row in range(len(grid)):
            for column in range(len(grid[0])):
                if grid[row][column] == '1':
                    num_islands += 1
                    self.island_dfs(grid, row, column)
        
        return num_islands
    
    def island_dfs(self, grid, row, column):
        min_row, max_row = 0, len(grid) - 1
        min_column, max_column = 0, len(grid[0]) - 1
        
        if (not min_row <= row <= max_row) or (not min_column <= column <= max_column):
            return
        elif grid[row][column] != '1':
            return
        else:
            grid[row][column] = '0'
            self.island_dfs(grid, row-1, column)
            self.island_dfs(grid, row+1, column)
            self.island_dfs(grid, row, column-1)
            self.island_dfs(grid, row, column+1)
