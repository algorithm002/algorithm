"""
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [2,4,1], k = 2
输出: 2
解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
示例 2:

输入: [3,2,6,5,0,3], k = 2
输出: 7
解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。

=============================
试试DP方式
日期/操作状态/k 三个状态 O(n*k)
=============================
勉强通过 只打败 50% 而且没办法优雅的解决k巨大的时候 只能两种解法
"""


class Solution:
    def maxProfit(self, k: int, prices) -> int:
        if not k or not prices:
            return 0

        if k >= len(prices)//2:
            r = 0
            for idx in range(1, len(prices)):
                d = prices[idx] - prices[idx - 1]
                r = max(r, r + d)
            return r

        cache = [[0, 0], [0, 0], [0, 0]]
        for idx in range(1, len(prices)):
            max_k = min(idx//2 + 1, k) + 1
            new_cache = [[0] * (k+1), [0] * (k+1), [0] * (k+1)]
            d = prices[idx] - prices[idx-1]
            for i in range(1, max_k):
                # 无操作
                new_cache[0][i] = (max(
                    cache[0][i],
                    cache[2][i],
                ))

                # 买入
                new_cache[1][i] = (max(
                    cache[0][i - 1],
                    cache[1][i] + d,
                    cache[2][i - 1],
                ))

                # 卖出
                new_cache[2][i] = max(cache[1][i] + d, 0)

            cache = new_cache

        return max(cache[0] + cache[1] + cache[2])


s = Solution()
print(s.maxProfit(2, [2, 1, 2, 0, 1]))
print(s.maxProfit(2, [2, 4, 1]))
print(s.maxProfit(2, [1, 4, 2, 7]))
print(s.maxProfit(2, [3, 2, 6, 5, 0, 3]))
print(s.maxProfit(2, [3, 3, 5, 0, 0, 3, 1, 4]))
