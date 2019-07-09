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
DP还是不熟，需要可以练习，先从暴力解法开始。
status 0不操作 1买 2卖
=======================
"""


class Solution:
    def maxProfit(self, prices) -> int:
        if not prices:
            return 0
        return self.recursion(0, 0, prices)

    def recursion(self, idx, status, prices):
        if idx >= len(prices):
            return 0
        if status == 0:
            return max(
                self.recursion(idx+1, 0, prices),
                self.recursion(idx+1, 1, prices)
            )
        if status == 1:
            return (prices[idx] - prices[idx-1]) + max(
                self.recursion(idx+1, 1, prices),
                self.recursion(idx+1, 2, prices),
            )
        if status == 2:
            return self.recursion(idx+1, 0, prices)


s = Solution()
print(s.maxProfit([1, 2, 3, 0, 2, 4, 5, 7, 8]) == 9)
print(s.maxProfit([1, 2, 3, 0, 2]) == 3)
