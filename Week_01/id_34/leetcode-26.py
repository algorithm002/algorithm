from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i = 0
        for j in range(1, len(nums)):
            if nums[i] != nums[j]:
                i += 1
                nums[i] = nums[j]
        return i + 1 if nums else 0


# 逆向, 但是没有原地排序
class Solution2:
    def removeDuplicates(self, nums: List[int]) -> int:
        for i in range(len(nums)-1, 0, -1):
            print(i)
            if nums[i] == nums[i-1]:
                nums.pop(i)
        return len(nums) if nums else 0

