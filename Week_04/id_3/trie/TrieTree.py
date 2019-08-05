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


tree = TrieTree()
tree.add('hello')
