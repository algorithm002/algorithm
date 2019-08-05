"""
全组合 避免重复元素出现
使用下标过滤掉已经组合过的是一个常用的技巧
"""


class Solution:
    def combine(self, n, k):
        results = []
        if n == 0:
            return results
        self.recursion([], 1, n+1, k, results)
        return results

    def recursion(self, curr, index, n, k, results):
        if len(curr) == k:
            results.append(curr)
            return

        for i in range(index, n):
            self.recursion(curr + [i], i + 1, n, k, results)


s = Solution()
print(s.combine(4, 2))
