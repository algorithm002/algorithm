class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        k = 1
        for n in nums:
            if n != nums[k - 1]:
                nums[k] = n
                k += 1
        return k
