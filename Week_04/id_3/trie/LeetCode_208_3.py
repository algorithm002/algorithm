class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
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
        node = self.root
        for c in word:
            if c in node.edges:
                node = node.edges[c]
            else:
                return False

        return node.is_word

    def startsWith(self, prefix: str) -> bool:
        if not prefix:
            return False
        node = self.root
        for c in prefix:
            if c in node.edges:
                node = node.edges[c]
            else:
                return False

        return True


class TrieNode:

    def __init__(self):
        self.edges = {}
        self.letter = None
        self.is_word = False


trie = Trie()

trie.insert("apple")
print(trie.search("apple"))
print(trie.search("app"))
print(trie.startsWith("app"))
trie.insert("app")
print(trie.search("app"))


