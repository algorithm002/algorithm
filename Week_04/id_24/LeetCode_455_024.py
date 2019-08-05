class Solution(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        childs = 0  # 注意：复数是 children
        cookies = 0
        g.sort()
        s.sort()
        for _ in range(len(g) + len(s)):
            if childs >= len(g) or cookies >= len(s): break
            if g[childs] <= s[cookies]:
                childs += 1
            cookies += 1
        return childs


g = [1,2,3]
s = [3]

print(Solution().findContentChildren(g, s))