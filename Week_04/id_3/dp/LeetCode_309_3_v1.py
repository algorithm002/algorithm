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
在recursion三个参数 下标 上一次的状态 数据
三种状态三种不同的下钻方式
技巧在于买入不卖的等待状态相当于每次的累加 每一步的状态都可以计算 便于缓存
price[5]-price[2] = (prices[3]-price[2])+(prices[4]-price[3])...
=======================
加入缓存 参数其实就是状态 当前下标配合当前状态构成了一个缓存
注意 二维数组初始化不可以这么写 [[0,0,0]]*n 这样所有数组的子元素都引用的同一个二级数组 [0,0,0]

完美，一条过 打败93%
"""


class Solution:
    def maxProfit(self, prices) -> int:
        if not prices:
            return 0
        return self.recursion(0, 0, prices, [[None, None, None] for _ in range(len(prices))])

    def recursion(self, idx, status, prices, cache):
        if idx >= len(prices):
            return 0
        if cache[idx][status] is not None:
            return cache[idx][status]
        if status == 0:
            r = max(
                self.recursion(idx+1, 0, prices, cache),
                self.recursion(idx+1, 1, prices, cache)
            )
        elif status == 1:
            r = (prices[idx] - prices[idx-1]) + max(
                self.recursion(idx+1, 1, prices, cache),
                self.recursion(idx+1, 2, prices, cache),
            )
        elif status == 2:
            r = self.recursion(idx+1, 0, prices, cache)
        cache[idx][status] = r
        return r


s = Solution()
print(s.maxProfit([1, 2, 3, 0, 2, 4, 5, 7, 8]) == 9)
print(s.maxProfit([1, 2, 3, 0, 2]) == 3)
print(s.maxProfit([1, 2, 3, -2, 5, 0, 2]) == 8)
