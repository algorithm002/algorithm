class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :type fee: int
        :rtype: int
        """
        if not prices: 
            return 0
        n = len(prices)
        # 0: 卖，1：买, 2:冷冻
        dp = [[0 for _ in range(n)] for _ in range(3)]
        dp[1][0] = -prices[0]
        for i in range(1,n):
            dp[0][i] = max(dp[0][i-1], dp[1][i-1] + prices[i], dp[2][i-1])
            dp[1][i] = max(dp[1][i-1], dp[2][i-1] - prices[i])
            dp[2][i] = dp[0][i-1]
        return dp[0][n-1]