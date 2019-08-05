"""
经典全组合
"""


class Solution:
    def subsets(self, nums):
        results = []
        if not nums:
            return results
        self.recursion([], nums, results)
        return results

    def recursion(self, cur, nums, results):
        results.append(cur)
        if not nums:
            return
        for i in range(len(nums)):
            self.recursion(cur + [nums[i]], nums[i+1:], results)


s = Solution()
print(s.subsets([1, 2, 3]))
