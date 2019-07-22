"""
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
================================
递归+缓存
"""


class Solution:
    def minimumTotal(self, triangle) -> int:
        if not triangle:
            return 0

        def rec(level, idx, triangle, cache):
            v = triangle[level][idx]
            if level == len(triangle) - 1:
                return v

            if cache[level][idx] is None:
                cache[level][idx] = v + min(
                    rec(level + 1, idx, triangle, cache),
                    rec(level + 1, idx + 1, triangle, cache)
                )

            return cache[level][idx]

        return rec(0, 0, triangle, [[None] * len(triangle[row]) for row in range(len(triangle) - 1)])


s = Solution()
print(s.minimumTotal([
    [2],
    [3, 4],
    [6, 5, 7],
    [4, 1, 8, 3]
]) == 11)
