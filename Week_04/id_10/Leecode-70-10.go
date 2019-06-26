package leecode

func climbStairs2(n int) int {
	// 递归方法
	if n == 1 || n == 2 {
		return n
	}

	return climbStairs(n-1) + climbStairs(n-2)
}

func climbStairs(n int) int {
	// dp方法
	if n == 1 || n == 2 {
		return n
	}
	dp := make([]int, n)
	dp[0] = 1
	dp[1] = 2
	for i := 2; i < n; i++ {
		dp[i] = dp[i-1] + dp[i-2]
	}
	return dp[n-1]
}
