#
# @lc app=leetcode.cn id=200 lang=python
#
# [200] 岛屿数量
#
# https://leetcode-cn.com/problems/number-of-islands/description/
#
# algorithms
# Medium (43.81%)
# Likes:    167
# Dislikes: 0
# Total Accepted:    16K
# Total Submissions: 36.5K
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


class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """

        dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]

        def sink(i, j):
            if i < 0 or i == len(grid) or j < 0 or j == len(
                    grid[i]) or grid[i][j] == '0':
                return 0
            grid[i][j] = '0'
            for k in range(4):
                sink(i + dx[k], j + dy[k])
            return 1

        ans = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                ans += sink(i, j)
        return ans


# print(Solution().numIslands([["1", "1", "1", "1", "0"],
#                              ["1", "1", "0", "1", "0"],
#                              ["1", "1", "0", "0", "0"],
#                              ["0", "0", "0", "0", "0"]]))

# print(Solution().numIslands([]))
