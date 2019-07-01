#
# @lc app=leetcode.cn id=78 lang=python
#
# [78] 子集
#
# https://leetcode-cn.com/problems/subsets/description/
#
# algorithms
# Medium (73.61%)
# Likes:    264
# Dislikes: 0
# Total Accepted:    22.9K
# Total Submissions: 31K
# Testcase Example:  '[1,2,3]'
#
# 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
#
# 说明：解集不能包含重复的子集。
#
# 示例:
#
# 输入: nums = [1,2,3]
# 输出:
# [
# ⁠ [3],
# [1],
# [2],
# [1,2,3],
# [1,3],
# [2,3],
# [1,2],
# []
# ]
#
#


class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        paths = set()

        def helper(i, path=()):
            paths.add(path)
            if i == len(nums):
                return
            helper(i+1, path + (nums[i],))
            helper(i+1, path)

        helper(0)
        return [list(i) for i in paths]


# print(Solution().subsets([1, 2, 3]))
