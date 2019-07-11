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
这个题依然是经典DP 状态编程了 天/操作状态/剩余次数
状态 0无操作 1买入 2卖出
先用递归暴力实现
=============================
这回缓存空间变大了不少 引入了k
汗，这东西没有冻结期 状态也只需要两个 0 1
=============================
如果把k纳入状态空间，那么有点儿太大了
目前的思路是用dict存储
============================= 可惜超时了
现在代码已经有点乱了
尝试在查询缓存后做一些剪枝操作 如果明显目前操作次数已经多于缓存，但是当前值又很少就可以剪掉了。
============================= 依然超时
只能对明显k太大的部分做特殊处理了
"""


class Solution:
    def maxProfit(self, k: int, prices) -> int:
        if not k or not prices:
            return 0
        if k > len(prices)//2:
            return self.simplify(0, 0, prices, [[None, None] for _ in range(len(prices))])
        return self.recursion(k, 0, 0, 0, prices, [[{}, {}] for _ in range(len(prices))])

    def simplify(self, idx, status, prices, cache):
        if idx >= len(prices):
            return 0
        if cache[idx][status] is not None:
            return cache[idx][status]
        next_idx = idx + 1
        if status == 0:
            r = max(
                self.simplify(next_idx, 0, prices, cache),
                self.simplify(next_idx, 1, prices, cache)
            )
        else:
            r = prices[idx] - prices[idx-1] + max(
                self.simplify(next_idx, 0, prices, cache),
                self.simplify(next_idx, 1, prices, cache)
            )
        cache[idx][status] = r
        return r

    def recursion(self, k, curr, idx, status, prices, cache):
        if idx >= len(prices) or k == -1:
            return 0
        tc = cache[idx][status]

        if k in tc:
            return tc[k][0]

        for tk in tc.keys():
            arr = tc[tk]
            if k < tk and curr <= arr[1]:
                return 0

        next_idx = idx + 1
        if status == 0:
            r = max(
                self.recursion(k, curr, next_idx, 0, prices, cache),
                self.recursion(k - 1, curr, next_idx, 1, prices, cache)
            )
        else:
            d = prices[idx] - prices[idx - 1]
            next_curr = curr + d
            r = d + max(
                self.recursion(k, next_curr, next_idx, 0, prices, cache),
                self.recursion(k, next_curr, next_idx, 1, prices, cache),
            )
        tc[k] = (r, curr)
        return r


s = Solution()
print(s.maxProfit(2, [2, 1, 2, 0, 1]))
print(s.maxProfit(2, [2, 4, 1]))
print(s.maxProfit(2, [3, 2, 6, 5, 0, 3]))
print(s.maxProfit(2, [3, 3, 5, 0, 0, 3, 1, 4]))
