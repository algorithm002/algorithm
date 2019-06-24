def isAnagram(s, t):
        # s1
        # return sorted(t) == sorted(s)

        # s2
        # if len(s) != len(t):
        #         return False
        # setS = dict()
        # setT = dict()
        # for i in range(len(s)):
        #     if (s[i] in setS):
        #         setS[s[i]] = setS[s[i]] + 1
        #     else:
        #         setS[s[i]] = 1
        #     if (t[i] in setT):
        #         setT[t[i]] = setT[t[i]] + 1
        #     else:
        #         setT[t[i]] = 1
        # return setS == setT

        # s3
        if len(s) != len(t):
            return False
        listS = [0] * 26
        listT = [0] * 26
        for i in range(len(s)):
            listS[ord(s[i]) - ord('a')] += 1
            listT[ord(t[i]) - ord('a')] += 1
        return listS == listT


print(isAnagram("anagram", "nagaram"))