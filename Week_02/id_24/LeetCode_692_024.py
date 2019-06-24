def topKFrequent(words, k):
        nums = {}
        for i in range(len(words)):
            if (words[i] in nums):
                nums[words[i]] += 1
            else:
                nums[words[i]] = 1
        sort_words = list(nums.keys())
        sort_words.sort()
        sort_words.sort(key = lambda item: nums[item], reverse = True)
        return sort_words[0:k]

print(topKFrequent(["i", "love", "leetcode", "i", "love", "coding"], 3))