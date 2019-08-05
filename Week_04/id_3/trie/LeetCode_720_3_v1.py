import collections


class TrieTree:

    def __init__(self):
        self.root = TrieNode()

    def add(self, word):
        node = self.root
        for w in word:
            node = node.edges[w]
            node.letter = w
        node.is_word = True


class TrieNode:

    def __init__(self):
        self.edges = collections.defaultdict(TrieNode)
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
        if (len(curr) - 1) > len(self.result):
            self.result[:] = curr[1:]

        for key in sorted(node.edges.keys()):
            sn = node.edges[key]
            if sn.is_word:
                self.dfs(sn, curr)

        curr.pop()


s = Solution()
# print(s.longestWord(["w", "wo", "wor", "worl", "world"]))
# print(s.longestWord(["a", "banana", "app", "appl", "ap", "apply", "apple"]))
print(s.longestWord( ["e", "el", "ele", "elep", "eleph", "elepha", "elephan", "elephant"]))
