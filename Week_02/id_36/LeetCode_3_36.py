#
# @lc app=leetcode.cn id=3 lang=python3
#
# [3] 无重复字符的最长子串
#
# https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
#
# algorithms
# Medium (29.74%)
# Likes:    1907
# Dislikes: 0
# Total Accepted:    136.6K
# Total Submissions: 457.9K
# Testcase Example:  '"abcabcbb"'
#
# 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
# 
# 示例 1:
# 
# 输入: "abcabcbb"
# 输出: 3 
# 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
# 
# 
# 示例 2:
# 
# 输入: "bbbbb"
# 输出: 1
# 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
# 
# 
# 示例 3:
# 
# 输入: "pwwkew"
# 输出: 3
# 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
# 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
# 
# 
#
# class Solution:
#     def lengthOfLongestSubstring(self, s: str) -> int:
#         n = len(s)
#         ans = 0

#         for i in range(n):
#             for j in range(i + 1, n + 1):
#                 if self.allUnique(s, i, j):
#                     ans = max(ans, j - i)
        
#         return ans
    
#     def allUnique(self, s, start, end):
#         set_v = set()
#         for i in range(start, end):
#             ch = s[i]
#             if ch in set_v:
#                 return False
#             set_v.add(ch)
        
#         return True


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        ans = 0
        start = 0
        dict_v = dict()
        for end in range(n):
            ch = s[end]
            if dict_v.get(ch, None):
                start = max(dict_v.get(ch), start)
            ans = max(ans, end - start + 1)
            dict_v[ch] = end + 1
        
        return ans
