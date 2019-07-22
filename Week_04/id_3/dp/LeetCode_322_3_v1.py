class Solution:
    def coinChange(self, coins, amount: int) -> int:
        if not coins:
            return -1

        return self.dfs(coins, amount, [None] * (amount+1))

    def dfs(self, coins, amount, cache):
        if amount == 0:
            return 0

        if amount < 0:
            return -1

        if cache[amount] is None:
            result = -1
            for c in coins:
                r = self.dfs(coins, amount - c, cache)
                if r == -1:
                    continue
                r += 1
                result = r if result == -1 else min(result, r)

            cache[amount] = result

        return cache[amount]


s = Solution()
print(s.coinChange([1, 2, 5], 11) == 3)
print(s.coinChange([186, 419, 83, 408], 6249))
