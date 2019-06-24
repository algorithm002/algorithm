class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        if not nums:
            return []
        k = k % len(nums)

        def reverse(start, end):
            while end > start:
                nums[start], nums[end] = nums[end], nums[start]
                start += 1
                end -= 1

        reverse(0, len(nums) - 1)
        reverse(0, k - 1)
        reverse(k, len(nums) - 1)
        return nums


print(Solution().rotate([1, 2, 3, 4, 5, 6, 7], 3))
print(Solution().rotate([], 4))
print(Solution().rotate([-1], 2))
print(Solution().rotate([1, 2, 3, 4, 5, 6], 2))
