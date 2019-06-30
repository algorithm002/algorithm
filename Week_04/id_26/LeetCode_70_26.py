#
# @lc app=leetcode.cn id=70 lang=python
#
# [70] 爬楼梯
#
# https://leetcode-cn.com/problems/climbing-stairs/description/
#
# algorithms
# Easy (45.50%)
# Likes:    513
# Dislikes: 0
# Total Accepted:    54.7K
# Total Submissions: 119.8K
# Testcase Example:  '2'
#
# 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
#
# 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
#
# 注意：给定 n 是一个正整数。
#
# 示例 1：
#
# 输入： 2
# 输出： 2
# 解释： 有两种方法可以爬到楼顶。
# 1.  1 阶 + 1 阶
# 2.  2 阶
#
# 示例 2：
#
# 输入： 3
# 输出： 3
# 解释： 有三种方法可以爬到楼顶。
# 1.  1 阶 + 1 阶 + 1 阶
# 2.  1 阶 + 2 阶
# 3.  2 阶 + 1 阶
#
#
#


class Solution(object):
    def climbStairs1(self, n):
        """
        :type n: int
        :rtype: int
        """
        if not n:
            return n
        dp = [0] * (n+1)
        dp[0] = dp[1] = 1
        for i in range(2, n+1):
            dp[i] = dp[i-1]+dp[i-2]
        return dp[n]

    def climbStairs2(self, n):
        """
        :type n: int
        :rtype: int
        """
        if not n:
            return n
        a, b = 1, 1
        for i in range(2, n+1):
            b, a = a + b, b
        return b


# print(Solution().climbStairs2(1))
# print(Solution().climbStairs2(3))
# print(Solution().climbStairs2(4))
