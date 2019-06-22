"""
典型二维数组DFS
退出条件:当前节点是雷或者出界
下钻条件:当前节点不是雷，且周边没有雷，则下钻周边8个节点
"""
DIRECT_LIST = [
    (-1, 0),
    (-1, 1),
    (0, 1),
    (1, 1),
    (1, 0),
    (1, -1),
    (0, -1),
    (-1, -1),
]


class Solution:
    def updateBoard(self, board, click):
        if not board:
            return board

        i, j = click
        v = board[i][j]
        if v == 'M':
            board[i][j] = 'X'
            return board
        self.dfs(board, i, j)
        return board

    def dfs(self, board, i, j):
        if i < 0 or j < 0 or i >= len(board) or j >= len(board[0]):
            return
        v = board[i][j]
        if v != 'E':
            return
        num = self.check_num(board, i, j)
        if num:
            board[i][j] = str(num)
        else:
            board[i][j] = 'B'
            for _i, _j in DIRECT_LIST:
                __i = i + _i
                __j = j + _j
                self.dfs(board, __i, __j)

    def check_num(self, board, i, j):
        num = 0
        for _i, _j in DIRECT_LIST:
            __i = i + _i
            __j = j + _j
            if __i < 0 or __j < 0 or __i >= len(board) or __j >= len(board[0]):
                continue
            if board[__i][__j] == 'M':
                num += 1
        return num


def check(board, click, result):
    s = Solution()
    r = s.updateBoard(board, click)
    print(r)
    print(r == result)


check([['E', 'E', 'E', 'E', 'E'],
       ['E', 'E', 'M', 'E', 'E'],
       ['E', 'E', 'E', 'E', 'E'],
       ['E', 'E', 'E', 'E', 'E']], [3, 0],
      [['B', '1', 'E', '1', 'B'],
       ['B', '1', 'M', '1', 'B'],
       ['B', '1', '1', '1', 'B'],
       ['B', 'B', 'B', 'B', 'B']])
