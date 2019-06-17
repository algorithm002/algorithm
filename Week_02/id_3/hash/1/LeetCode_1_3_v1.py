class Solution:
    def twoSum(self, nums, target):
        cache = {}
        for i in range(len(nums)):
            n = nums[i]
            v = target - n
            if v in cache:
                return [cache.get(v), i]
            else:
                cache[n] = i

        return []


s = Solution()
print(s.twoSum([2, 7, 11, 15], 9))
