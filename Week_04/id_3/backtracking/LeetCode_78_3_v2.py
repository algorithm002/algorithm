"""
经典全组合 直接调用库函数 其实为了点进去看看他的实现代码
"""
import itertools


class Solution:
    def subsets(self, nums):
        results = []
        for i in range(len(nums) + 1):
            for r in itertools.combinations(nums, i):
                results.append(list(r))
        return results


s = Solution()
print(s.subsets([1, 2, 3]))
