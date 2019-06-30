class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums_dict = {}
        for i in range(len(nums)):
            if nums[i] in nums_dict:
                nums_dict[nums[i]] += 1
            else:
                nums_dict[nums[i]] = 1
            if nums_dict[nums[i]] > len(nums)/2:
                return nums[i]

test = [3,2,3,2]

print(Solution().majorityElement(test))