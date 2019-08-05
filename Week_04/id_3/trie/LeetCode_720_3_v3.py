"""
在v1基础上尝试做更多的剪枝操作
====
加入count 尝试提前过滤掉不需要访问的节点
时间复杂度O(n*k) k是单词平均长度
"""
import collections


class TrieTree:

    def __init__(self):
        self.root = TrieNode()

    def add(self, word):
        node = self.root
        for w in word:
            node = node.edges[w]
            node.letter = w
            node.count += 1
        node.is_word = True


class TrieNode:

    def __init__(self):
        self.edges = collections.defaultdict(TrieNode)
        self.count = 0
        self.letter = None
        self.is_word = False


class Solution:
    def longestWord(self, words):
        if not words:
            return ''

        tree = TrieTree()
        for word in words:
            if word == '':
                continue
            tree.add(word)

        self.result = []
        self.dfs(tree.root, [])
        return ''.join(self.result)

    def dfs(self, node, curr):
        curr.append(node.letter)
        diff_length = len(curr) - 1 - len(self.result)
        if diff_length > 0:
            self.result[:] = curr[1:]

        for key in sorted(node.edges.keys()):
            sn = node.edges[key]
            if sn.is_word and sn.count >= diff_length:
                self.dfs(sn, curr)

        curr.pop()


s = Solution()
print(s.longestWord(["w", "wo", "wor", "worl", "world"]))
print(s.longestWord(["a", "banana", "app", "appl", "ap", "apply", "apple"]))
print(s.longestWord( ["e", "el", "ele", "elep", "eleph", "elepha", "elephan", "elephant"]))
