#
# @lc app=leetcode.cn id=26 lang=python3
#
# [26] 删除排序数组中的重复项
# 
# 笔记 : 读题目的时候，受到题目中的删除这个词的影响，陷入到如何删除数组中的某一个元素，实际上题目是要求返回不同元素的个数
#
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n, count = len(nums), 0
        
        if n < 2:
            return n

        for i in range(1, n):
            if nums[i] != nums[count]:
                count += 1
                nums[count] = nums[i]
        
        return count + 1

