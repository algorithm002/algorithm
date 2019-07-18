"""
老套路 DP递推 自底向上
00默认是终点递推比较容易
"""


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if not m or not n:
            return 0

        cache = [1] * n
        for _m in range(1, m):
            _cache = [1] * n
            for _n in range(1, n):
                _cache[_n] = _cache[_n-1] + cache[_n]

            cache = _cache

        return cache[n - 1]


s = Solution()
print(s.uniquePaths(3, 2) == 3)
print(s.uniquePaths(7, 3) == 28)
print(s.uniquePaths(3, 7) == 28)
