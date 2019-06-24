class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if s =="" and t == "":
            return True
        
        if len(s) != len(t) or len(set(s)) != len(set(t)):
            return False
        
        for char in set(s):
            s_count = s.count(char)
            t_count = t.count(char)
            if s_count != t_count:
                return False
        return True
