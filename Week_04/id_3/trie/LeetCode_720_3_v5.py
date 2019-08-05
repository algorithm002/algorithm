"""
在v4的基础上进一步优化
按字母正序 字母长度倒序
这样可以更加稳准狠的剪枝
======
真是又简单又高效……
O(nlogn)
======
打败了100%，值得纪念
"""


class Solution:
    def longestWord(self, words):
        if not words:
            return ''
        words_set = set(words)
        words.sort()
        words.sort(key=len, reverse=True)
        for word in words:
            w = word
            while w in words_set:
                w = w[:-1]

            if len(w) == 0:
                return word


s = Solution()
print(s.longestWord(["vsw", "vs", "zwu", "vsx", "nc", "o", "vswus", "orv", "imf", "i", "v", "zw", "vs"]))
print(s.longestWord(["w", "wo", "wor", "worl", "world"]))
print(s.longestWord(["a", "banana", "app", "appl", "ap", "apply", "apple"]))
print(s.longestWord(["e", "el", "ele", "elep", "eleph", "elepha", "elephan", "elephant"]))
print(s.longestWord(["ogz", "eyj", "e", "ey", "hmn", "v", "hm", "ogznkb", "ogzn", "hmnm", "eyjuo", "vuq", "ogznk", "og", "eyjuoi", "d"]))
print(s.longestWord(["m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"]))
print(s.longestWord(["rac", "rs", "ra", "on", "r", "otif", "o", "onpdu", "rsf", "rs", "ot", "oti", "racy", "onpd"]))
print(s.longestWord(
    ["ts", "e", "x", "pbhj", "opto", "xhigy", "erikz", "pbh", "opt", "erikzb", "eri", "erik", "xlye", "xhig", "optoj",
     "optoje", "xly", "pb", "xhi", "x", "o"]))
