class Solution(object):
    def maxProfit(self, prices, fee):
        """
        :type prices: List[int]
        :type fee: int
        :rtype: int
        """
        n = len(prices)
        dp = [[0 for _ in range(2)] for _ in range(2)]
        dp[1] = -prices[0]
        for i in range(1,n):
            dp[0][1] = max(dp[0][0], dp[1][0] + prices[i] - fee)
            dp[1][1] = max(dp[1][0], dp[0][0] - prices[i])
            dp[0][0] = dp[0][1]
            dp[1][0] = dp[1][1]
        return dp[0][1]