class Solution:
    # 第一想法  二分法  没有思路
    # 第二想法  dp  从第一个位置递推到最后，没写出来
    # 第三想法  暴力法 dfs 遍历所有
    # 时间复杂度 O(2^N)  空间复杂度 O(1) N为格子总数
    # 提交超时
    def calculateMinimumHP(self, dungeon: List[List[int]]) -> int:
        if len(dungeon) == 0:
            return 0
        if len(dungeon[0]) == 0:
            return 0
        self.dungeon = dungeon
        self.minblood = -1
        self._dfs(0, 0, 0, dungeon[0][0])
        return self.minblood + 1

    def _dfs(self, i, j, minblood, routeblood):
        m = len(self.dungeon)
        n = len(self.dungeon[0])
        if minblood < 0 - routeblood:
            minblood = 0 - routeblood
        if i == m - 1 and j == n - 1:
            if self.minblood == -1 or self.minblood > minblood:
                self.minblood = minblood
        if self.minblood > -1 and self.minblood < minblood:
            return
        if i < m - 1:
            self._dfs(i + 1, j, minblood, routeblood + self.dungeon[i + 1][j])
        if j < n - 1:
            self._dfs(i, j + 1, minblood, routeblood + self.dungeon[i][j + 1])

    # 看了解法和评论区  使用逆序dp
    # 从最后一个位置向前推,的确没想到
    # 时间复杂度 O(N)  空间复杂度 O(N) N为格子总数
    def calculateMinimumHP2(self, dungeon: List[List[int]]) -> int:
        if len(dungeon) == 0:
            return 0
        if len(dungeon[0]) == 0:
            return 0
        m = len(dungeon)
        n = len(dungeon[0])
        dp = [[0 for y in range(n)] for x in range(m)]
        dp[m - 1][n - 1] = max(1, 1 - dungeon[m - 1][n - 1])
        for i in range(m - 2, -1, -1):
            dp[i][n - 1] = max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1)
        for i in range(n - 2, -1, -1):
            dp[m - 1][i] = max(dp[m - 1][i + 1] - dungeon[m - 1][i], 1)
        for i in range(m - 2, -1, -1):
            for j in range(n - 2, -1, -1):
                dp[i][j] = min(max(1, dp[i + 1][j] - dungeon[i][j]), max(1, dp[i][j + 1] - dungeon[i][j]))
        return max(dp[0][0], 1)