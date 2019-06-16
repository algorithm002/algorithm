def twoSum(nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # s1
        # for i in range(len(nums) - 1):
        #     for j in range(i + 1, len(nums)):
        #         if nums[i] + nums[j] == target:
        #             return [i, j] 
        # return []
        
        # s2
        # resHash = {}
        # for i in range(len(nums)):
        #     resHash[target - nums[i]] = i
        # for j in range(len(nums)):
        #     if (nums[j] in resHash and j != resHash[nums[j]]):
        #         return [j, resHash[nums[j]]]
        # return []

        # s3
        resHash = {}
        for i in range(len(nums)):
            if (nums[i] in resHash and i != resHash[nums[i]]):
                return [resHash[nums[i]], i]
            resHash[target - nums[i]] = i
        return []
        
print(twoSum([3,2,4], 6))