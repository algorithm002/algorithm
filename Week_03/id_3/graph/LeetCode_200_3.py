"""
grid为二维数组
给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

输入:
11110
11010
11000
00000
输出: 1

输入:
11000
11000
00100
00011
输出: 3
"""


class Solution:
    def numIslands(self, grid) -> int:
        if not grid:
            return 0

        width = len(grid[0])
        height = len(grid)

        count = 0
        for i in range(height):
            arr = grid[i]
            for j in range(width):
                ceil = arr[j]
                if ceil == '1':
                    count += 1
                    self.dfs(grid, i, j, width, height)
        return count

    def dfs(self, grid, i, j, width, height):
        if i < 0 or i >= height or j < 0 or j >= width:
            return
        if grid[i][j] == '0':
            return
        grid[i][j] = '0'
        self.dfs(grid, i + 1, j, width, height)
        self.dfs(grid, i - 1, j, width, height)
        self.dfs(grid, i, j + 1, width, height)
        self.dfs(grid, i, j - 1, width, height)


s = Solution()

print(s.numIslands(
    [
        ["1", "1", "1", "1", "0"],
        ["1", "1", "0", "1", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "0", "0", "0"]
    ]
))

print(s.numIslands(
    [
        ["1", "1", "0", "0", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "1", "0", "0"],
        ["0", "0", "0", "1", "1"]
    ]
))
