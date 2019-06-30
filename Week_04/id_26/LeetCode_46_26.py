#
# @lc app=leetcode.cn id=46 lang=python
#
# [46] 全排列
#
# https://leetcode-cn.com/problems/permutations/description/
#
# algorithms
# Medium (69.33%)
# Likes:    291
# Dislikes: 0
# Total Accepted:    28.6K
# Total Submissions: 41.1K
# Testcase Example:  '[1,2,3]'
#
# 给定一个没有重复数字的序列，返回其所有可能的全排列。
#
# 示例:
#
# 输入: [1,2,3]
# 输出:
# [
# ⁠ [1,2,3],
# ⁠ [1,3,2],
# ⁠ [2,1,3],
# ⁠ [2,3,1],
# ⁠ [3,1,2],
# ⁠ [3,2,1]
# ]
#
#


class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        时间复杂度：O(n^2)
        """
        ans = []
        n = len(nums)

        def helper(path=[], invited=set()):
            if len(path) == n:
                return ans.append(path)
            for j in nums:
                if j not in invited:
                    invited.add(j)
                    helper(path+[j], invited)
                    invited.remove(j)

        helper()
        return ans
