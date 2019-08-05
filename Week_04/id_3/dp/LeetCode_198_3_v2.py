"""
使用非递归方式解决
=======
套路 递归+缓存 可以解决的问题，容易直接推出递推公式

递归的思路一般是从大到小，n问题依赖n-1问题的解决(也有例外)

递推是从底部开始推导最优解 自底向上 将原来缓存中的值计算出来

=======
本题的解法就 n下标 的最优解是 nums[n] + cache[n-2] 与 cache[n-1] 之间的比较
"""


class Solution:
    def rob(self, nums):
        if not nums:
            return 0

        length = len(nums)
        if length == 1:
            return nums[0]

        cache = [nums[0], max(nums[0], nums[1])]
        index = 2
        while index < length:
            cache.append(
                max(
                    nums[index] + cache[index - 2],
                    cache[index - 1]
                )
            )
            index += 1

        return cache[index - 1]


s = Solution()
print(s.rob([1, 2, 3, 1]), s.rob([1, 2, 3, 1]) == 4)
print(s.rob([2, 7, 9, 3, 1]), s.rob([2, 7, 9, 3, 1]) == 12)
