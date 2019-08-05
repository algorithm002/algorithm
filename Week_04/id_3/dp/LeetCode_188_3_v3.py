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
试试找波峰波谷的方式
=============================
这么做是不行的，如果是不限次数，那么没有问题，如果限制次数，这种方式就无法使用了。
1,2,4,2,9 如果只能交易一次，那么1-9是最优解。如果可以交易2次，那么1-4,2-9是最优解。
只能用于k>len(prices)//2的情况 而且用小顶堆优化也还没有dp的解法快
=============================
失败！！
"""
import heapq


class Solution:
    def maxProfit(self, k: int, prices) -> int:
        if not k or not prices:
            return 0

        last = prices[0]
        status = 0
        last_min = None
        heap = []
        for price in prices:
            if last == price:
                continue
            if price > last:
                if status != 1:
                    last_min = last
                    status = 1
            else:
                if status != -1:
                    if last_min is not None:
                        self.push(heap, k, last - last_min)
                    status = -1

            last = price
        if status == 1:
            self.push(heap, k, last - last_min)

        return sum(sorted(heap[-k:]))

    def push(self, heap, k, value):
        if len(heap) >= k:
            heapq.heapreplace(heap, value)
        else:
            heapq.heappush(heap, value)


s = Solution()
# print(s.maxProfit(2, [2, 1, 2, 0, 1]))
# print(s.maxProfit(2, [2, 4, 1]))
# print(s.maxProfit(2, [1, 4, 2, 7]))
# print(s.maxProfit(2, [3, 2, 6, 5, 0, 3]))
# print(s.maxProfit(2, [3, 3, 5, 0, 0, 3, 1, 4]))
# print(s.maxProfit(2, [1, 2, 4, 2, 5, 7, 2, 4, 9, 0]))
