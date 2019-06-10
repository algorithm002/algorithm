class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
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
