class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        substring, length, max_len = "", 0, 0
        for c in s:
            if c in substring:
                index = substring.find(c)
                substring = substring[(index + 1)::]
            substring += c
            length = len(substring)
            if length > max_len:
                max_len = length
        return max_len
