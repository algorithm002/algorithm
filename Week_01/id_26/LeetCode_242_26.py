class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False
        m = {}
        for i in s:
            if m.get(i) is None:
                m[i] = 1
            else:
                m[i] += 1
        for i in t:
            if m.get(i) is None:
                return False
            else:
                m[i] -= 1
        for i in m.values():
            if not i == 0:
                return False
        return True
