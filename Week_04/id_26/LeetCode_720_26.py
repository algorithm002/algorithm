#!/usr/bin/python
# -*- coding: UTF-8 -*-
# @lc app=leetcode.cn id=720 lang=python
#
# [720] 词典中最长的单词
#
# https://leetcode-cn.com/problems/longest-word-in-dictionary/description/
#
# algorithms
# Easy (42.52%)
# Likes:    36
# Dislikes: 0
# Total Accepted:    2.7K
# Total Submissions: 6.3K
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


import collections


class Solution(object):
    def longestWord1(self, words):
        """
        :type words: List[str]
        :rtype: str
        解法1: 先排序，后面的单词去掉最后一个字母在前面出现过则添加入集合，找出最长的即可，相同长度取前面的
        """
        words.sort()
        visited, ans = set(), ''
        for word in words:
            if len(word) == 1 or word[:-1] in visited:
                visited.add(word)
                if len(ans) < len(word):
                    ans = word
        return ans

    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        解法2: 字典树
        使用两种不同的遍历方式
        """
        trie = Trie()
        for word in words:
            trie.insert(word)
        # return trie.longest2()
        return trie.longest1()


class TrieNode:
    def __init__(self):
        self.children = {}
        self.word = ''
        self.end = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
        node.end = True
        node.word = word

    def longest1(self):
        import collections
        queue = collections.deque([self.root])
        ans = ''

        while queue:
            node = queue.pop()
            for c, n in node.children.items():
                if n.end:
                    queue.append(n)
                    if len(ans) < len(n.word) or n.word < ans:
                        ans = n.word
        return ans

    def longest2(self):
        self.ans = ''

        def dfs(node):
            for c, n in node.children.items():
                if n.end:
                    dfs(n)
                    if len(self.ans) < len(n.word) or (len(self.ans) == len(n.word) and self.ans > n.word):
                        self.ans = n.word

        dfs(self.root)
        return self.ans


# print(Solution().longestWord(
    # ["a", "banana", "app", "appl", "ap", "apply", "apple"]))
# print(Solution().longestWord(["w", "wo", "wor", "worl", "world"]))
# print(Solution().longestWord(["m", "mo", "moc", "moch", "mocha",
        #   "l", "la", "lat", "latt", "latte", "c", "ca", "cat"]))
# print(Solution().longestWord(["rac", "rs", "ra", "on", "r",
#   "otif", "o", "onpdu", "rsf", "rs", "ot", "oti", "racy", "onpd"]))
# print(Solution().longestWord(["yo", "ew", "fc", "zrc", "yodn",
#   "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"]))
# print(Solution().longestWord(["m", "mo", "moc", "moch", "mocha",
#   "l", "la", "lat", "latt", "latte", "c", "ca", "cat"]))


# queue = collections.deque()
# for i in [1, 2, 3, 4, 5, 6, 7, 8]:
#     queue.append(i)
# while queue:
#     print(queue.pop())
