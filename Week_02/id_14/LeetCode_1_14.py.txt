class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        obj = {}
        for i in range(len(nums)):
            num = nums[i]
            if target - num in obj:
                return obj[target-num], i
            if num not in obj:
                obj[num] = i