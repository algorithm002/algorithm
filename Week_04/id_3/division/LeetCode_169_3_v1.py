"""
既然是分治专题的，那么估计用hash的玩法是没啥意义了
看答案 分治有点儿勉强 算是学习个思路吧
O(nlogn)

似乎分治总会比暴力要好，只要从n^2变成nlogn，如果找不到最优的O(n)，那么先用nlogn也不错。
"""


class Solution:
    def majorityElement(self, nums):
        if not nums:
            return None
        # return self._division1(nums)
        return self._division2(nums, 0, len(nums) - 1)

    def _division1(self, nums):
        if len(nums) == 1:
            return nums[0]

        mid = len(nums) // 2
        left = self._division1(nums[:mid])
        right = self._division1(nums[mid:])
        if left == right:
            return left

        lc = 0
        rc = 0
        for n in nums:
            if n == left:
                lc += 1
                continue
            if n == right:
                rc += 1
                continue
        return left if lc > rc else right

    def _division2(self, nums, low, high):
        if low == high:
            return nums[low]

        mid = low + (high-low)//2
        left = self._division2(nums, low, mid)
        right = self._division2(nums, mid+1, high)

        if left == right:
            return left

        lc = 0
        rc = 0
        for i in range(low, high+1):
            n = nums[i]
            if left == n:
                lc += 1
                continue
            if right == n:
                rc += 1
                continue

        return left if lc > rc else right


s = Solution()
# print(s.majorityElement([2, 2, 1, 1, 1, 2, 2]))
print(s.majorityElement([3, 3, 4]))
