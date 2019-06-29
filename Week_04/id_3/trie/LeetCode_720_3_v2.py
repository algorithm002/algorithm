"""
尝试用数组实现Trie树 但是性能似乎没啥改善
"""
letter_a = ord('a')


class TrieTree:

    def __init__(self):
        self.root = TrieNode()

    def add(self, word):
        node = self.root
        for w in word:
            index = ord(w) % letter_a
            if not node.edges[index]:
                node.edges[index] = TrieNode()
            node = node.edges[index]
            node.letter = w
        node.is_word = True


class TrieNode:

    def __init__(self):
        self.edges = [None] * 26
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

        for sn in node.edges:
            if not sn or not sn.is_word:
                continue
            self.dfs(sn, curr)
        curr.pop()


s = Solution()
print(s.longestWord(["w", "wo", "wor", "worl", "world"]))
print(s.longestWord(["a", "banana", "app", "appl", "ap", "apply", "apple"]))
print(s.longestWord( ["e", "el", "ele", "elep", "eleph", "elepha", "elephan", "elephant"]))
