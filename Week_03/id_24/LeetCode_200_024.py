class Solution(object):
    def numIslands(self, grid):
        if not grid or not grid[0]:
            return 0
        self.grid = grid
        self.max_x = len(grid)
        self.max_y = len(grid[0])
        self.visited = set()
        result = [self._dfs(i, j) for i in range(self.max_x) for j in range(self.max_y)]
        # print(result)
        return sum(result)
    
    def _dfs(self, x, y):
        if not self._check_valid(x, y):
            return 0
        # print("self.grid[x][y]: ", self.grid[x][y])
        self.visited.add((x, y))
        self._dfs(x-1, y)
        self._dfs(x+1, y)
        self._dfs(x, y-1)
        self._dfs(x, y+1)
        return 1

    def _check_valid(self, x, y):
        # print((x, y))
        if x < 0 or y < 0 or x >= self.max_x or y >= self.max_y:
            return False
        elif self.grid[x][y] == '0' or (x, y) in self.visited:
            return False
        else:
            return True


grid = [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]

sol = Solution()
print(sol.numIslands(grid))
        
        