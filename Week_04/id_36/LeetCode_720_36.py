#
# @lc app=leetcode.cn id=720 lang=python3
#
# [720] 词典中最长的单词
#
# https://leetcode-cn.com/problems/longest-word-in-dictionary/description/
#
# algorithms
# Easy (42.64%)
# Likes:    36
# Dislikes: 0
# Total Accepted:    2.6K
# Total Submissions: 6.2K
# Testcase Example:  '["w","wo","wor","worl","world"]'
#
# 
# 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
# 
# 若无答案，则返回空字符串。
# 
# 示例 1:
# 
# 
# 输入: 
# words = ["w","wo","wor","worl", "world"]
# 输出: "world"
# 解释: 
# 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
# 
# 
# 示例 2:
# 
# 
# 输入: 
# words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
# 输出: "apple"
# 解释: 
# "apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
# 
# 
# 注意:
# 
# 
# 所有输入的字符串都只包含小写字母。
# words数组长度范围为[1,1000]。
# words[i]的长度范围为[1,30]。
# 
# 
#
# class Solution:
#     def longestWord(self, words: List[str]) -> str:
#         ans = ""
#         word_set = set(words)
#         for word in words:
#             word_len = len(word)
#             ans_len = len(ans)
#             if word_len > ans_len or word_len == ans_len and word < ans:
#                 if all(word[:k] in word_set for k in range(1, word_len)):
#                     ans = word
        
#         return ans

class Solution:
    def longestWord(self, words: List[str]) -> str:
        ans = ""
        word_set = set(words)
        words.sort(key = lambda c : (-(len(c)), c))
        for word in words:
            if all(word[:k] in word_set for k in range(1, len(word))):
                return word
        
        return ""

