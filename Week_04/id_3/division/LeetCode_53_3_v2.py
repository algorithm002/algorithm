"""
容我思考一下怎么分治
======
有点儿费劲啊
======
看了网上的一些答案，大体思路如下：
如果加入限制条件，经过下标i的最大连续子数组解决就非常容易了，只需要i向两边延伸即可找到最大值。
控制i是中间节点，则有三种情况，
1 解包含i
2 解在i左侧
3 解在i右侧

_max1方法是创建新数组
_max2方法是玩弄下标

反正不管怎么整，速度都不行，勉强通过

时间复杂度 O(nlogn)
"""


class Solution:
    def maxSubArray(self, nums):
        if not nums:
            return 0

        # return self._max1(nums)
        return self._max2(nums, 0, len(nums) - 1)

    def _max1(self, nums):
        if len(nums) == 1:
            return nums[0]

        if len(nums) == 2:
            return max(nums[0], nums[1], sum(nums))

        mid = len(nums) // 2

        sum_value = 0
        left_max = 0
        for i in range(mid - 1, -1, -1):
            sum_value += nums[i]
            left_max = max(left_max, sum_value)

        sum_value = 0
        right_max = 0
        for i in range(mid + 1, len(nums)):
            sum_value += nums[i]
            right_max = max(right_max, sum_value)

        return max(nums[mid] + left_max + right_max, self._max1(nums[:mid]), self._max1(nums[mid + 1:]))

    def _max2(self, nums, left, right):
        if left == right:
            return nums[left]
        if (left + 1) == right:
            return max(nums[left], nums[right], nums[left] + nums[right])
        mid = left + (right - left) // 2

        sum_value = 0
        left_max = 0
        for i in range(mid - 1, left-1, -1):
            sum_value += nums[i]
            left_max = max(left_max, sum_value)

        sum_value = 0
        right_max = 0
        for i in range(mid + 1, right+1):
            sum_value += nums[i]
            right_max = max(right_max, sum_value)

        return max(nums[mid] + left_max + right_max, self._max2(nums, left, mid - 1), self._max2(nums, mid + 1, right))


s = Solution()
print(s.maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
print(s.maxSubArray([-2, 3, -1, 3, -3, 2, 1, -5, 4]))
print(s.maxSubArray([-1]))
print(s.maxSubArray([-2, -1]))
print(s.maxSubArray([-2, -3, -1]))
