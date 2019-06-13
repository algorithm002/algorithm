class Solution:
    def topKFrequent(self, words, k):
        word_map = {}
        count_list = []
        for w in words:
            word_map[w] = word_map.get(w, 0) + 1

        count_map = {}
        for (w, count) in word_map.items():
            count_list.append(count)
            wl = count_map.get(count, [])
            wl.append(w)
            count_map[count] = wl

        count_list.sort(reverse=True)
        r = []
        last_count = 0
        for count in count_list:
            if last_count == count:
                continue
            else:
                last_count = count
            count_map[count].sort()
            for w in count_map[count]:
                r.append(w)
                if len(r) == k:
                    return r


s = Solution()
# print(s.topKFrequent(["i", "love", "leetcode", "i", "love", "coding"], 2))
# print(s.topKFrequent(["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], 4))
print(s.topKFrequent(["i", "love", "leetcode", "i", "love", "coding"], 3))
