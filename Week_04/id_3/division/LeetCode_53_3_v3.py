"""
我想到了一个诡异的方案
假设数组nums为解，则nums大于包含它的所有父数组，和它包含的所有子数组。
暴力解法浪费时间之处在于累加是一个浪费时间的过程，而如果数组的和，求比之长度小1位的子数组则很容易，只需要分别减去左右两边节点即可。

[1,2,3,4,5] sum=15
[1,2,3,4] sum=15-5 [2,3,4,5] sum=15-1
result=max(sum(nums), sum(nums[1:]...)

===============================
失败了，我真是吃饱撑的 本质上还是个O(n^2)的方案
首次sum是n 然后减法的次数是 2+4+8+..+n 非常的尴尬
"""


class Solution:
    def maxSubArray(self, nums):
        if not nums:
            return 0
        return self._max2(nums, sum(nums), 0, len(nums) - 1)

    def _max(self, nums, sum_value):
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1], nums[0] + nums[1])

        return max(sum_value,
                   self._max(nums[1:], sum_value - nums[0]),
                   self._max(nums[:-1], sum_value - nums[-1]))

    def _max2(self, nums, sum_value, left, right):
        if left == right:
            return nums[left]
        if len(nums) == 2:
            return max(nums[left], nums[right], nums[left] + nums[right])

        return max(sum_value,
                   self._max2(nums, sum_value - nums[left], left + 1, right),
                   self._max2(nums, sum_value - nums[right], left, right - 1))


s = Solution()
print(s.maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
print(s.maxSubArray([-2, 3, -1, 3, -3, 2, 1, -5, 4]))
print(s.maxSubArray([-1]))
print(s.maxSubArray([-2, -1]))
print(s.maxSubArray([-2, -3, -1]))
