"""
矩阵中的最长递增路径
思路：DFS + 缓存
DFS过程由于需求是数值递增，所以在下钻到过程中不会出现回路，不需要缓存去重。
由于需要找到全局最优解，所以也不需要依赖贪心。
"""


class Solution:
    def longestIncreasingPath(self, matrix):
        if not matrix:
            return 0
        col_length = len(matrix)
        row_length = len(matrix[0])
        cache = [
            [0] * row_length for _ in range(col_length)
        ]
        r = 0
        for i in range(col_length):
            for j in range(row_length):
                r = max(r, self.dfs(matrix, cache, i, j, col_length, row_length, None))

        return r

    def dfs(self, matrix, cache, i, j, col_length, row_length, prev):
        if i < 0 or i >= col_length or j < 0 or j >= row_length:
            return 0

        curr = matrix[i][j]
        if prev is not None and prev >= curr:
            return 0

        if cache[i][j]:
            return cache[i][j]

        r = 1 + max(
            self.dfs(matrix, cache, i+1, j, col_length, row_length, curr),
            self.dfs(matrix, cache, i-1, j, col_length, row_length, curr),
            self.dfs(matrix, cache, i, j+1, col_length, row_length, curr),
            self.dfs(matrix, cache, i, j-1, col_length, row_length, curr),
        )
        cache[i][j] = r
        return r


s = Solution()
print(s.longestIncreasingPath(
[
    [9, 9, 4],
    [6, 6, 8],
    [2, 1, 1]
]))
