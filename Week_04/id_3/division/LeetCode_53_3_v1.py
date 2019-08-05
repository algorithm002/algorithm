"""
额，这题分治能做吗，我还是先按朴素的想法来一下
暴力方法最差是O(n^3)优化是O(n^2)

利用经典的当前累加值，减去历史最小值的方法
例如 [1,-2,1,2,3]
当迭代i=4时，当前累加值5,历史最小值-1,所以最大值5-(-1)=6
"""


class Solution:
    def maxSubArray(self, nums):
        if not nums:
            return 0
        min_value = 0
        result = nums[0]
        sum_value = 0

        for n in nums:
            sum_value += n
            result = max(result, sum_value - min_value)
            min_value = min(sum_value, min_value)

        return result


s = Solution()
print(s.maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
print(s.maxSubArray([-1]))
