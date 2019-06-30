#
# @lc app=leetcode.cn id=211 lang=python
#
# [211] 添加与搜索单词 - 数据结构设计
#
# https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/description/
#
# algorithms
# Medium (38.92%)
# Likes:    51
# Dislikes: 0
# Total Accepted:    2.8K
# Total Submissions: 7.3K
# Testcase Example:  '["WordDictionary","addWord","addWord","addWord","search","search","search","search"]\n[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]'
#
# 设计一个支持以下两种操作的数据结构：
#
# void addWord(word)
# bool search(word)
#
#
# search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
#
# 示例:
#
# addWord("bad")
# addWord("dad")
# addWord("mad")
# search("pad") -> false
# search("bad") -> true
# search(".ad") -> true
# search("b..") -> true
#
#
# 说明:
#
# 你可以假设所有单词都是由小写字母 a-z 组成的。
#
#


class TrieNode(object):
    def __init__(self):
        self.children = {}
        self.end = False


class WordDictionary(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def addWord(self, word):
        """
        Adds a word into the data structure.
        :type word: str
        :rtype: None
        """
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
        node.end = True

    def search(self, word):
        """
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        :type word: str
        :rtype: bool
        """
        self.ans = False
        self._match(self.root, word)
        return self.ans

    def _match(self, root, word):
        if not word:
            if root.end:
                self.ans = root.end
            return
        if word[0] == '.':
            for node in root.children.values():
                self._match(node, word[1:])
        if word[0] not in root.children:
            return
        self._match(root.children[word[0]], word[1:])
