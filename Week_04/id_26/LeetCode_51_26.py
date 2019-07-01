#
# @lc app=leetcode.cn id=51 lang=python
#
# [51] N皇后
#
# https://leetcode-cn.com/problems/n-queens/description/
#
# algorithms
# Hard (62.79%)
# Likes:    181
# Dislikes: 0
# Total Accepted:    9K
# Total Submissions: 14.2K
# Testcase Example:  '4'
#
# n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
#
#
#
# 上图为 8 皇后问题的一种解法。
#
# 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
#
# 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
#
# 示例:
#
# 输入: 4
# 输出: [
# ⁠[".Q..",  // 解法 1
# ⁠ "...Q",
# ⁠ "Q...",
# ⁠ "..Q."],
#
# ⁠["..Q.",  // 解法 2
# ⁠ "Q...",
# ⁠ "...Q",
# ⁠ ".Q.."]
# ]
# 解释: 4 皇后问题存在两个不同的解法。
#
#
#


class Solution(object):

    def solveNQueens1(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        解法1：深度遍历，用set记录和、差、列
        """
        ans = []

        def dfs(i, col=set(), add=set(), minus=set(), grid=[]):
            if i == n:
                return ans.append(grid)
            for j in range(n):
                if j not in col and i + j not in add and i - j not in minus:
                    col.add(j)
                    add.add(i+j)
                    minus.add(i-j)
                    line = ''.join(['Q' if m == j else '.' for m in range(n)])
                    dfs(i+1, col, add, minus, grid + [line])
                    col.remove(j)
                    add.remove(i+j)
                    minus.remove(i-j)
        dfs(0)
        return ans

    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        解法2：深度遍历，用位记录和、差、列
        """
        ans = []

        def dfs(pos=[], row=0, col=0, pie=0, na=0):
            if row == n:
                ans.append(pos)
                return
            bits = ~(col | pie | na) & ((1 << n) - 1)
            while bits > 0:
                p = bits & -bits
                line = ''.join(['Q' if p >> i & 1 else '.' for i in range(n)])
                dfs(pos + [line], row + 1, col | p,
                    (pie | p) << 1, (na | p) >> 1)
                bits &= bits - 1

        dfs()
        return ans


print(Solution().solveNQueens(4))
