class Solution(object):
    def maxProfit(self, prices, fee):
        """
        :type prices: List[int]
        :type fee: int
        :rtype: int
        """
        n = len(prices)
        # 0: 卖，1：买,
        dp = [[0 for _ in range(n)] for _ in range(2)]
        dp[1][0] = -prices[0]
        for i in range(1,n):
            dp[0][i] = max(dp[0][i-1], dp[1][i-1] + prices[i] - fee)
            dp[1][i] = max(dp[1][i-1], dp[0][i-1] - prices[i])
        return max(dp[0][n-1], dp[1][n-1])

prices = [1,3,2,8,4,9]
fee = 2

print(Solution().maxProfit(prices, fee))