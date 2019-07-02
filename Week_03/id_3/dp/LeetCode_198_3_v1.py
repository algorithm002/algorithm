"""
第一直观的解法还是dfs，先试试
===============
超时了 要加上缓存
===============
超过97.8%
"""


class Solution:
    def rob(self, nums):
        return self.dfs(False, 0, nums, [None] * len(nums))

    def dfs(self, prev_steal, index, nums, cache):
        if not nums or index >= len(nums):
            return 0

        if not cache[index]:
            r1 = self.dfs(False, index+1, nums, cache)
            r2 = nums[index] + self.dfs(True, index+1, nums, cache)
            cache[index] = (r1, max(r1, r2))
        return cache[index][0] if prev_steal else cache[index][1]


s = Solution()
print(s.rob([1, 2, 3, 1]), s.rob([1, 2, 3, 1]) == 4)
print(s.rob([2, 7, 9, 3, 1]), s.rob([2, 7, 9, 3, 1]) == 12)
