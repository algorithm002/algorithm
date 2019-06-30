#Data Node to hold char data
class Node:
    def __init__(self, val, isWord=False):
        self.val = val
        self.child = {}
        self.isWord = isWord

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = Node("")
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root
        for ch in word:
            if ch not in curr.child:
                curr.child[ch] = Node(ch)
            curr = curr.child.get(ch)
        
        curr.isWord = True
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        for ch in word:
            if ch in curr.child:
                curr = curr.child.get(ch)
            else:
                return False
        
        return curr.isWord

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
        for ch in prefix:
            if ch in curr.child:
                curr = curr.child.get(ch)
            else:
                return False
        
        return True
