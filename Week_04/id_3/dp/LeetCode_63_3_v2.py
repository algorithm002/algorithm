"""
尝试DP
"""


class Solution:
    def uniquePathsWithObstacles(self, grid) -> int:
        if not grid or not grid[0]:
            return 0

        for m in range(len(grid)):
            for n in range(len(grid[0])):
                if grid[m][n] == 1:
                    grid[m][n] = 0
                    continue

                if m == 0 and n == 0:
                    grid[m][n] = 1
                    continue

                if n > 0:
                    grid[m][n] += grid[m][n-1]
                if m > 0:
                    grid[m][n] += grid[m-1][n]

        return grid[m][n]


s = Solution()
print(s.uniquePathsWithObstacles([
    [0, 0, 0],
    [0, 1, 0],
    [0, 0, 0]
]))
print(s.uniquePathsWithObstacles([[1, 0]]))
print(s.uniquePathsWithObstacles([[0, 1]]))
