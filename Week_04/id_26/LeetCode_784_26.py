#
# @lc app=leetcode.cn id=784 lang=python
#
# [784] 字母大小写全排列
#
# https://leetcode-cn.com/problems/letter-case-permutation/description/
#
# algorithms
# Easy (55.43%)
# Likes:    76
# Dislikes: 0
# Total Accepted:    5.3K
# Total Submissions: 9.5K
# Testcase Example:  '"a1b2"'
#
# 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
#
#
# 示例:
# 输入: S = "a1b2"
# 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
#
# 输入: S = "3z4"
# 输出: ["3z4", "3Z4"]
#
# 输入: S = "12345"
# 输出: ["12345"]
#
#
# 注意：
#
#
# S 的长度不超过12。
# S 仅由数字和字母组成。
#
#
#


class Solution(object):
    def letterCasePermutation(self, S):
        """
        :type S: str
        :rtype: List[str]
        """
        paths = []

        def helper(i, path=''):
            if i == len(S):
                return paths.append(path)
            if S[i].isdigit():
                return helper(i+1, path+S[i])
            helper(i+1, path + S[i].lower())
            helper(i+1, path + S[i].upper())
        helper(0)
        return paths


# print(Solution().letterCasePermutation('3z4'))
# print(Solution().letterCasePermutation('12345'))
# print(Solution().letterCasePermutation('a1b2'))
# print(Solution().letterCasePermutation(''))
