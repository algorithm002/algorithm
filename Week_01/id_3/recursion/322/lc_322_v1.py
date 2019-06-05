class Solution:

    def coin_change(self, coins, amount):
        if amount == 0:
            return 0
        _max = amount + 1
        self.max = _max
        self.result = _max
        self.dp = [0 for i in range(amount)]
        coins.sort(reverse=True)
        self.dfs(coins, amount, 0, 0)
        if self.result == _max:
            return -1
        else:
            return self.result

    def dfs(self, coins, amount, cur_sum, cur_times):
        if cur_times >= self.result:
            return
        for c in coins:
            new_sum = cur_sum + c
            if new_sum > amount:
                continue
            next_times = cur_times + 1
            if new_sum == amount:
                self.result = min(self.result, next_times)
                return
            dp = self.dp
            if not dp[new_sum] or dp[new_sum] > next_times:
                dp[new_sum] = next_times
                self.dfs(coins, amount, new_sum, next_times)

            if len(coins) > 0:
                coins = coins[1:]


print(Solution().coin_change([186, 419, 83, 408], 6249))
