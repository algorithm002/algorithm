class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        思路：
        1) 防止重复结果，所以先排序，遍历时跳过相邻的重复值
        2) 二分查找，大于0则右测向左移动，小于0则左边向右移动
        """
        nums.sort()
        ret, n = [], len(nums)
        for i in range(n):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            left = i + 1
            right = n - 1
            while left < right:
                tmp = nums[i] + nums[left] + nums[right]
                if tmp == 0:
                    s = [nums[i], nums[left], nums[right]]
                    ret.append(s)
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    right -= 1
                    left += 1
                elif tmp > 0:
                    right -= 1
                else:
                    left += 1
        return ret
