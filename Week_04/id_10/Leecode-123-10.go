package leecode

func maxProfit(prices []int) int {
	if len(prices) == 0 {
		return 0
	}
	// dp[i][k][t]  i 代表第几天  k 代表买入股票k次  t 是否持有股票 0 否 1 是
	dp := make([][][]int, len(prices))
	n := len(prices)
	for i := 0; i < len(dp); i++ {
		dp[i] = [][]int{[]int{0, 0}, []int{0, 0}, []int{0, 0}}
	}
	const INT_MIN = 0 - (1e9 + 7)
	dp[0][1][1] = 0 - prices[0]
	dp[0][1][0] = INT_MIN
	dp[0][2][0] = INT_MIN
	dp[0][2][1] = INT_MIN
	for i := 1; i < len(prices); i++ {
		dp[i][1][0] = max(dp[i-1][1][1]+prices[i], dp[i-1][1][0])
		dp[i][1][1] = max(0-prices[i], dp[i-1][1][1])
		dp[i][2][0] = max(dp[i-1][2][1]+prices[i], dp[i-1][2][0])
		dp[i][2][1] = max(dp[i-1][1][0]-prices[i], dp[i-1][2][1])
	}
	return max(0, dp[n-1][1][0], dp[n-1][2][0])

}

func max(arr ...int) int {
	maxNum := arr[0]
	for i := 1; i < len(arr); i++ {
		if maxNum < arr[i] {
			maxNum = arr[i]
		}
	}
	return maxNum
}
