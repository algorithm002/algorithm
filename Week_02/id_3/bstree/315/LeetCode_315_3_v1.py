"""
    0 建立排序数组
    1 倒序遍历
    2 二分查找找到坐标
"""


class Solution:
    def countSmaller(self, nums):
        _sorted = []
        length = len(nums)
        for i in range(length - 1, -1, -1):
            v = nums[i]
            nums[i] = self.bs(_sorted, v)

        return nums

    def bs(self, _sorted, v):
        low = 0
        high = len(_sorted) - 1
        while low <= high:
            mid = low + (high-low)//2
            if _sorted[mid] >= v:
                high = mid - 1
            else:
                low = mid + 1

        _sorted.insert(low, v)
        return low


s = Solution()
print(s.countSmaller([5, 2, 6, 1]) == [2, 1, 1, 0])
print(s.countSmaller([-1, -1]) == [0, 0])
