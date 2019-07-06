"""
递推比较直观 n = cache[n-1]+cache[n-2]
"""


class Solution:
    def climbStairs(self, n: int) -> int:
        if not n:
            return 0

        cache = [1, 1]
        index = 2
        while index <= n:
            cache.append(cache[index - 1] + cache[index - 2])
            index += 1

        return cache[n]


s = Solution()
print(s.climbStairs(4))
print(s.climbStairs(10))
