class WordDictionary(object):
    def __init__(self):
        self.len2words = collections.defaultdict(list) 

    def addWord(self, word):
        self.len2words[len(word)].append(word)

    def search(self, word):
        words = self.len2words[len(word)]
        for i, char in enumerate(word):
            words = [w for w in words if char in ('.', w[i])]
            if not words: return False
        return True
