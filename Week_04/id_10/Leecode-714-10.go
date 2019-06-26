package leecode

func maxProfit(prices []int, fee int) int {
	if len(prices) == 0 {
		return 0
	}
	//dp解法
	dp := make([][]int, len(prices))
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, 2)
	}
	dp[0][0] = 0             // 第N天 手里没有股票 赚得最多的钱
	dp[0][1] = 0 - prices[0] // 第N天 手里有股票 赚得最多的钱
	for i := 1; i < len(prices); i++ {
		dp[i][0] = max(dp[i-1][1]+prices[i]-fee, dp[i-1][0])
		dp[i][1] = max(dp[i-1][1], dp[i-1][0]-prices[i])
	}
	return dp[len(prices)-1][0]
}

func max(a, b int) int {
	if a >= b {
		return a
	}
	return b
}

func maxProfit2(prices []int, fee int) int {
	//贪心算法
	result := 0
	buytime := 0
	selltime := 0
	for i := 1; i < len(prices); i++ {
		if selltime > buytime && prices[selltime]-prices[buytime] > fee && prices[selltime]-prices[i] > fee {
			result += (prices[selltime] - prices[buytime]) - fee
			buytime = i
			selltime = i
		} else if prices[buytime] > prices[i] {
			buytime = i
			selltime = i
		} else if prices[selltime] < prices[i] {
			selltime = i
		}
	}
	if selltime > buytime && prices[selltime]-prices[buytime] > fee {
		result += (prices[selltime] - prices[buytime]) - fee
	}
	return result
}
