#
# @lc app=leetcode.cn id=169 lang=python3
#
# [169] 求众数
#
# https://leetcode-cn.com/problems/majority-element/description/
#
# algorithms
# Easy (59.73%)
# Likes:    259
# Dislikes: 0
# Total Accepted:    49.1K
# Total Submissions: 82.1K
# Testcase Example:  '[3,2,3]'
#
# 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
# 
# 你可以假设数组是非空的，并且给定的数组总是存在众数。
# 
# 示例 1:
# 
# 输入: [3,2,3]
# 输出: 3
# 
# 示例 2:
# 
# 输入: [2,2,1,1,1,2,2]
# 输出: 2
# 
# 

# # 暴力法
# class Solution:
#     def majorityElement(self, nums: List[int]) -> int:
#         majority_num = len(nums)//2

#         for num in nums:
#             count = 0
#             for n in nums:
#                 if n == num:
#                     count += 1

#             if count > majority_num:
#                 return num
        
#         return -1

# # 哈希表-1
# class Solution:
#     def majorityElement(self, nums: List[int]) -> int:
#         if not nums or len(nums) < 1:
#             return 0

#         counts = {}

#         for num in nums:
#             if not counts.get(num):
#                 counts[num] = 1
#             else:
#                 counts[num] += 1
        
#         max_value = 0
#         majority = 0
        
#         for key, value in counts.items():
#             if value > max_value:
#                 max_value = value
#                 majority = key

#         return majority

# # 哈希表-2
# class Solution:
#     def majorityElement(self, nums: List[int]) -> int:
#         import collections
#         counts = collections.Counter(nums)
#         return max(counts.keys(), key = counts.get)

# # 排序
# class Solution:
#     def majorityElement(self, nums: List[int]) -> int:
#         nums_len = len(nums)
#         if not nums or nums_len < 1:
#             return 0
        
#         nums.sort()
#         return nums[nums_len // 2]

# # 分治
# class Solution:
#     def majorityElement(self, nums: List[int]) -> int:
#         def majority_element_rec(low, high):
#             if low == high:
#                 return nums[low]
            
#             middle = low + (high - low) // 2
#             left = majority_element_rec(low, middle)
#             right = majority_element_rec(middle + 1, high)

#             if left == right:
#                 return left
            
#             # left_count = sum(1 for i in range(low, high + 1) if nums[i] == left)
#             # right_count = sum(1 for i in range(low, high + 1) if nums[i] == right)
#             left_count = 0
#             right_count = 0
#             for i in range(low, high + 1):
#                 if nums[i] == left:
#                     left_count += 1
#                 elif nums[i] == right:
#                     right_count += 1

#             return left if left_count > right_count else right
        
#         return majority_element_rec(0, len(nums) - 1)

# Boyer-Moore 投票算法
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count = 0
        candidate = None

        for num in nums:
            if count == 0:
                candidate = num
            count += (1 if num == candidate else -1)
        
        return candidate

