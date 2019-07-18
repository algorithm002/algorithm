"""
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？

例如，上图是一个7 x 3 的网格。有多少可能的路径？

说明：m 和 n 的值均不超过 100。

示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28
===========================
老套路先试试回溯+缓存
优化 碰触到右或者下的边可直接返回1
缓存为m*n数组，mn启点 00终点，这样变量能少传两个。
"""


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if not m or not n:
            return 0
        return self.rec(m-1, n-1, [[None for _ in range(n)] for _ in range(m)])

    def rec(self, m, n, cache):
        if not m or not n:
            return 1

        if cache[m][n] is None:
            cache[m][n] = self.rec(m-1, n, cache) + self.rec(m, n-1, cache)

        return cache[m][n]


s = Solution()
print(s.uniquePaths(3, 2) == 3)
print(s.uniquePaths(7, 3) == 28)
