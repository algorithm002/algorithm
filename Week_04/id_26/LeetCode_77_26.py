#
# @lc app=leetcode.cn id=77 lang=python
#
# [77] 组合
#
# https://leetcode-cn.com/problems/combinations/description/
#
# algorithms
# Medium (68.18%)
# Likes:    125
# Dislikes: 0
# Total Accepted:    12.9K
# Total Submissions: 18.8K
# Testcase Example:  '4\n2'
#
# 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
#
# 示例:
#
# 输入: n = 4, k = 2
# 输出:
# [
# ⁠ [2,4],
# ⁠ [3,4],
# ⁠ [2,3],
# ⁠ [1,2],
# ⁠ [1,3],
# ⁠ [1,4],
# ]
#
#


class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        ans = []

        def helper(path=[]):
            if len(path) == k:
                return ans.append(path)
            for i in range(path[-1] + 1 if path else 1, n+1):
                helper(path+[i])
        helper()
        return ans


# print(Solution().combine(4, 2))
# print(Solution().combine(0, 0))
