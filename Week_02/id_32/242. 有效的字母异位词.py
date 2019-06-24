class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        m = {}
        for i in s:
            if i not in m:
                m[i] = 1
            else:
                m[i] += 1
        for i in t:
            if i not in m:
                return False
            else:
                m[i] -= 1
        for i in m.values():
            if i != 0:
                return False
        return True
    