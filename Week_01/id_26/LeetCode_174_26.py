#!/usr/bin/python
# -*-coding:utf-8 -*-

class Solution(object):
    def calculateMinimumHP(self, dungeon):
        """
        :type dungeon: List[List[int]]
        :rtype: int
        """
        m = len(dungeon)
        n = len(dungeon[0])
        dp = [[1 << 31] * (n + 1) for _ in range(m + 1)]
        dp[m][n-1], dp[m-1][n] = 1, 1
        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                dp[i][j] = min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]
                if dp[i][j] <= 0:
                    dp[i][j] = 1
        return dp[0][0]


print Solution().calculateMinimumHP([[-2, -3, 3], [-5, -10, 1], [10, 30, -5]])
