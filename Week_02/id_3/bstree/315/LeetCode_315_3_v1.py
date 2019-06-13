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

    def bs(self, nums, v):
        if not nums:
            nums.append(v)
            return 0

        low = 0
        length = len(nums)
        high = length - 1
        while low <= high:
            mid = low + int((high-low)/2)
            if nums[mid] >= v:
                high = mid - 1
            else:
                low = mid + 1

        index = high + 1
        nums.insert(index, v)
        return index


s = Solution()
print(s.countSmaller([5, 2, 6, 1]) == [2, 1, 1, 0])
print(s.countSmaller([-1, -1]) == [0, 0])
