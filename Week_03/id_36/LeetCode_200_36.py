#
# @lc app=leetcode.cn id=200 lang=python3
#
# [200] 岛屿数量
#
# https://leetcode-cn.com/problems/number-of-islands/description/
#
# algorithms
# Medium (44.05%)
# Likes:    171
# Dislikes: 0
# Total Accepted:    16.5K
# Total Submissions: 37.4K
# Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
#
# 给定一个由 '1'（陆地）和
# '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
# 
# 示例 1:
# 
# 输入:
# 11110
# 11010
# 11000
# 00000
# 
# 输出: 1
# 
# 
# 示例 2:
# 
# 输入:
# 11000
# 11000
# 00100
# 00011
# 
# 输出: 3
# 
# 
#


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def sink(i, j):
            if 0 <= i < len(grid) and 0 <= j < len(grid[0]) and grid[i][j] == '1':
                grid[i][j] = '0'
                list(map(sink, (i-1, i, i+1, i), (j, j-1, j, j+1)))
        return sum(grid[i][j] == '1' and not sink(i, j) for i in range(len(grid)) for j in range(len(grid[0])))
