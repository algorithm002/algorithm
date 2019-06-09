import math
def removeDuplicates(nums):
        if len(nums) <= 1: return len(nums)
        i = 1
        j = 0
        while i < len(nums):
            if nums[i] > nums[j]:
                j = j + 1
                if i > j:
                     nums[j] = nums[i]
            i = i + 1
        return j + 1

removeDuplicates([1])
