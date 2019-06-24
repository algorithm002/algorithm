class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s or len(s) == 0:
            return 0
        low = high = 0
        length = len(s)
        result = 1
        cache_set = set()
        while high < length:
            v = s[high]
            if v not in cache_set:
                cache_set.add(v)
                high += 1
                result = max(result, high - low)
            else:
                while low < high:
                    low_v = s[low]
                    cache_set.remove(low_v)
                    low += 1
                    if low_v == v:
                        break

        return result


s = Solution()
print(s.lengthOfLongestSubstring("abcabcbb") == 3)
print(s.lengthOfLongestSubstring("bbbbb") == 1)
print(s.lengthOfLongestSubstring("pwwkew") == 3)
