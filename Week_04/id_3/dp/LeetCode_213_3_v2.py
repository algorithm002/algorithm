"""
DP思路 缓存依然是两个状态 首家偷不偷 本家偷不偷
cache = [首不偷本不偷, 首不偷本偷, 首偷本不偷, 首偷本偷]
在初始状态和最后结果状态容易下标判断错误
"""


class Solution:
    def rob(self, nums) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums)

        # 初始状态从下标2开始比较容易实现
        cache = [0, nums[1], nums[0], nums[0]]
        for i in range(2, len(nums) - 1):
            v = nums[i]
            cache = [
                max(cache[0], cache[1]),
                v + cache[0],
                max(cache[2], cache[3]),
                v + cache[2],
            ]

        last = nums[len(nums) - 1]
        return max(last + cache[0], cache[1], cache[2], cache[3])


s = Solution()
print(s.rob([2, 3, 2]) == 3)
print(s.rob([1, 2, 3, 2]) == 4)
print(s.rob([1, 2, 3, 1]) == 4)
