"""
最原始回溯解决n皇后方法
每一行判断是否可行，对角线方向用set可以简易实现
"""


class Solution:
    def solveNQueens(self, n):
        results = []
        if n == 0:
            return []
        self.recursion(n, [], [0]*n, set(), set(), results)
        return results

    def recursion(self, n, curr, dis_col, dis_pie, dis_na, results):
        row = len(curr) - 1
        if n == (row + 1):
            results.append(curr)
            return
        for i in range(n):
            if dis_col[i] == 1:
                continue
            pie = i + row
            if pie in dis_pie:
                continue
            na = i - row
            if na in dis_na:
                continue

            line = ['.'] * n
            line[i] = 'Q'

            dis_col[i] = 1
            dis_pie.add(pie)
            dis_na.add(na)

            self.recursion(n, curr + [''.join(line)], dis_col, dis_pie, dis_na, results)

            dis_col[i] = 0
            dis_pie.remove(pie)
            dis_na.remove(na)


s = Solution()
print(s.solveNQueens(4))
