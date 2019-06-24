def lengthOfLongestSubstring(s):
        # s1
        # sub = {}
        # sub_len = 0
        # for i in range(len(s)):
        #     if s[i] in sub:
        #         sub_len = max(sub_len, len(sub))
        #         sub = {key : value for key, value in sub.items() if value > sub[s[i]]}
        #     sub[s[i]] = i
        # return max(sub_len, len(sub))

        # s2
        sub = {}
        sub_len = 0
        mark = 0
        for i in range(len(s)):
            if s[i] in s[mark:i]:
                sub_len = max(sub_len, i - mark)
                mark = sub[s[i]] + 1
            sub[s[i]] = i
        return max(sub_len, len(s) - mark)

print(lengthOfLongestSubstring("abcabcabghg"))
