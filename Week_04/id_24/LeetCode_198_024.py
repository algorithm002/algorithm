class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])
        dn_2 = nums[0]
        dn_1 = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            dn = max(dn_1, dn_2 + nums[i])
            dn_2 = dn_1
            dn_1 = dn
        return dn