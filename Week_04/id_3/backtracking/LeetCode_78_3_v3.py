"""
经典全组合 非递归
"""
import itertools


class Solution:
    def subsets(self, nums):
        results = [[]]
        for n in nums:
            _results = []
            for pn in results:
                _results.append(pn + [n])
            results += _results
        return results


s = Solution()
print(s.subsets([1, 2, 3]))
