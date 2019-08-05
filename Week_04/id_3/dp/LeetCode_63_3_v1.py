"""
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

===================================
老套路 先递归
直接用初始化数组当缓存
用None取代本来是结果0的点位 避免重复计算 -1取代障碍物点位
"""


class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid) -> int:
        if not obstacleGrid or not obstacleGrid[0]:
            return 0

        for m in range(len(obstacleGrid)):
            for n in range(len(obstacleGrid[0])):
                obstacleGrid[m][n] = None if obstacleGrid[m][n] == 0 else -1

        return self.rec(0, 0, len(obstacleGrid)-1, len(obstacleGrid[0])-1, obstacleGrid)

    def rec(self, m, n, m_max, n_max, grid):
        if m > m_max or n > n_max:
            return 0

        if grid[m][n] == -1:
            return 0

        if m == m_max and n == n_max:
            return 1

        if grid[m][n] is None:
            grid[m][n] = self.rec(m+1, n, m_max, n_max, grid) + self.rec(m, n+1, m_max, n_max, grid)

        return grid[m][n]


s = Solution()
print(s.uniquePathsWithObstacles([
    [0, 0, 0],
    [0, 1, 0],
    [0, 0, 0]
]))
print(s.uniquePathsWithObstacles([[1, 0]]))
print(s.uniquePathsWithObstacles([[0, 1]]))
