class Solution(object):
    def topKFrequent(self, words, k):
        obj = {}
        for word in words:
            obj[word] = obj.get(word, 0) + 1
        ret = sorted(obj, key=lambda word: (-obj[word], word))
        return ret[:k]