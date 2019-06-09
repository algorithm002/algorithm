# Language: Python
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k %= len(nums)
        if k:
            nums[:k], nums[k:] = nums[-k:], nums[:-k]
