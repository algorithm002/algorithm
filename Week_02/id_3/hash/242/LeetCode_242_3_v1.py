c_a = ord('a')


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        arr = [0] * 26
        for c in s:
            arr[ord(c) % c_a] += 1

        for c in t:
            i = ord(c) % c_a
            if arr[i] == 0:
                return False
            arr[i] -= 1

        return True


s = Solution()
print(s.isAnagram("anagram", "nagaram"))
print(s.isAnagram("rat", "car"))
