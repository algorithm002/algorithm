"""
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]

=======================
尝试dp递推
按套路是写出来了，但是真的好难按正常思路去理解。
尝试理解一下

所谓的自底向上还是很难理解，还是顺序写dp比较容易理解
当前如果是空仓 则最大值是 之前空仓或者卖出的最大值
如果是买入状态 则最大值是 之前空仓或者买入状态+差值的最大值
如果是卖出操作 则最大值是 之前是买入状态的最大值
======================
优化缓存数组，减少内存使用。目前这种n只依赖n-1的dp，没必要记录全量。
======================
还得多练练
"""


class Solution:
    def maxProfit(self, prices) -> int:
        if not prices:
            return 0
        return self.dp2(prices)

    def dp1(self, prices):
        cache = (0, 0, 0)
        for idx in range(len(prices) - 1, 0, -1):
            d = prices[idx] - prices[idx - 1]
            cache = (
                max(cache[0], cache[1]),
                max(cache[1], cache[2]) + d,
                cache[0],
            )
        return max(cache[0], cache[1])

    def dp2(self, prices):
        cache = (0, 0, 0)
        for idx in range(1, len(prices)):
            d = prices[idx] - prices[idx - 1]
            cache = (
                max(cache[0], cache[2]),
                max(cache[0], cache[1] + d),
                cache[1] + d
            )
        return max(cache)


s = Solution()
print(s.maxProfit([1, 2, 3, 0, 2, 4, 5, 7, 8]), s.maxProfit([1, 2, 3, 0, 2, 4, 5, 7, 8]) == 9)
print(s.maxProfit([1, 2, 3, 0, 2]), s.maxProfit([1, 2, 3, 0, 2]) == 3)
print(s.maxProfit([1, 2, 3, -2, 5, 0, 2]), s.maxProfit([1, 2, 3, -2, 5, 0, 2]) == 8)
