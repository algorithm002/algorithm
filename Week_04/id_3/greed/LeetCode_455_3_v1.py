"""
直接贪心好了，最大的饼干找胃口最大的孩子
"""


class Solution:
    def findContentChildren(self, g, s) -> int:
        if not g or not s:
            return 0

        s.sort()
        g.sort()

        gi = len(g)
        r = 0
        for si in range(len(s) - 1, - 1, -1):
            sv = s[si]
            for gi in range(gi - 1, -1, -1):
                gv = g[gi]
                if gv <= sv:
                    r += 1
                    break

        return r


s = Solution()
print(s.findContentChildren([1, 2, 3], [1, 1]))
print(s.findContentChildren([1, 2], [1, 2, 3]))
print(s.findContentChildren([10, 9, 8, 7], [5, 6, 7, 8]))
