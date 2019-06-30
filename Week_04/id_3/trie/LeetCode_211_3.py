class WordDictionary:

    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        node = self.root
        for c in word:
            if c not in node.edges:
                node.edges[c] = TrieNode()
                node.letter = c
            node = node.edges[c]
        node.is_word = True

    def search(self, word: str) -> bool:
        if not word:
            return False
        return self._dfs(self.root, word)

    def _dfs(self, node, word):
        for i in range(len(word)):
            c = word[i]

            if c == '.':
                for sn in node.edges.values():
                    sr = self._dfs(sn, word[i+1:])
                    if sr:
                        return True
                return False

            if c in node.edges:
                node = node.edges[c]
            else:
                return False

        return node.is_word


class TrieNode:

    def __init__(self):
        self.edges = {}
        self.letter = None
        self.is_word = False


trie = WordDictionary()
trie.addWord("bad")
trie.addWord("dad")
trie.addWord("mad")
print(trie.search('pad'))
print(trie.search('bad'))
print(trie.search('.ad'))
print(trie.search('b..'))
