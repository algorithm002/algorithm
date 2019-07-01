#
# @lc app=leetcode.cn id=53 lang=python3
#
# [53] 最大子序和
#
# https://leetcode-cn.com/problems/maximum-subarray/description/
#
# algorithms
# Easy (45.55%)
# Likes:    1009
# Dislikes: 0
# Total Accepted:    65.3K
# Total Submissions: 142.9K
# Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
#
# 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
# 
# 示例:
# 
# 输入: [-2,1,-3,4,-1,2,1,-5,4],
# 输出: 6
# 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
# 
# 
# 进阶:
# 
# 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
# 
# # 暴力法
# class Solution:
#     def maxSubArray(self, nums: List[int]) -> int:
#         n = len(nums)
#         if n <= 0:
#             return 0
        
#         tmp = nums[0]
#         max_value = tmp

#         for i in range(1, n):
#             tmp = tmp + nums[i] if tmp > 0 else nums[i]
#             max_value = max(max_value, tmp)
        
#         return max_value

# class Solution:
#     def maxSubArray(self, nums: List[int]) -> int:
#         n = len(nums)
#         if n <= 0:
#             return 0
#         elif n == 1:
#             return nums[0]
        
#         max_value = nums[0]
#         tmp = 0

#         for num in nums:
#             tmp = tmp + num if tmp > 0 else num
#             max_value = max(max_value, tmp)
        
#         return max_value

# 分治法
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        n = len(nums)
        if n <= 0:
            return 0
        elif n == 1:
            return nums[0]
        
        middle = n // 2
        max_left = self.maxSubArray(nums[0 : middle])
        max_right = self.maxSubArray(nums[middle : n])
    
        tmp = 0
        max_le = nums[middle - 1]
        for i in range(middle - 1, -1, -1):
            tmp += nums[i]
            max_le = max(max_le, tmp)
        
        max_ri = nums[middle]
        tmp = 0
        for i in range(middle, n):
            tmp += nums[i]
            max_ri = max(max_ri, tmp)
        
        return max(max_left, max_right, max_le + max_ri)

