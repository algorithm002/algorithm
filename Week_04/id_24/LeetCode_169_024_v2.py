class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        majority = nums[0]
        majority_times = 1
        majority_flag = 0
        for i in range(1, len(nums)):
            if nums[i] == majority: 
                majority_times += 1
            elif nums[i] > nums[i-1]: 
                majority_flag = i
            if i - majority_flag + 1 > majority_times:
                majority = nums[i]
                majority_times = i - majority_flag - 1 
            if majority_times > len(nums) / 2: break
        return majority 