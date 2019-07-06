"""
先用第一印象的数学公式解决
======
想到的不行 本质是个n^n 的解决方案
======
试试递归+缓存的玩法
"""
import math


class Solution:
    def climbStairs(self, n: int) -> int:
        if not n:
            return 0
        return self.stair(n, [0] * (n+1))

    def stair(self, n, cache):
        if n == 0:
            return 0
        if n == 1:
            return 1
        if n == 2:
            return 2

        if cache[n]:
            return cache[n]

        r = self.stair(n-1, cache) + self.stair(n-2, cache)
        cache[n] = r
        return r


s = Solution()
# print(s.climbStairs(3))
print(s.climbStairs(4))
