"""
先按自己的方法试试
回溯 + 2状态缓存 第一家偷不偷 本家偷不偷
"""


class Solution:
    def rob(self, nums) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        return self.rec(0, 0, 0, nums, [[None, None] for _ in range(len(nums)-1)])

    def rec(self, idx, prev, first, nums, cache):
        if idx == len(nums) - 1:
            return nums[idx] if not prev and not first else 0

        next_x = idx + 1
        if idx == 0:
            return max(
                self.rec(next_x, 0, 0, nums, cache),
                nums[0] + self.rec(next_x, 1, 1, nums, cache)
            )

        if not cache[idx][first]:
            r1 = self.rec(next_x, 0, first, nums, cache)
            r2 = nums[idx] + self.rec(next_x, 1, first, nums, cache)
            cache[idx][first] = [r1, r2]

        r1, r2 = cache[idx][first]
        return r1 if prev == 1 else max(r1, r2)


s = Solution()
# print(s.rob([2, 3, 2]) == 3)
# print(s.rob([1, 2, 3, 2]) == 4)
print(s.rob([1, 2, 3, 1]) == 4)
