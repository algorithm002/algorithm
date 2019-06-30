#
# @lc app=leetcode.cn id=70 lang=python3
#
# [70] 爬楼梯
#
# https://leetcode-cn.com/problems/climbing-stairs/description/
#
# algorithms
# Easy (45.72%)
# Likes:    518
# Dislikes: 0
# Total Accepted:    55.5K
# Total Submissions: 121.4K
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
class Solution:
    def climbStairs(self, n: int) -> int:
        def climb_stairs(i, n, m_dict):
            if i > n:
                return 0
            elif i == n:
                return 1
            
            if m_dict.get(i) and m_dict.get(i) > 0:
                return m_dict.get(i)
            
            m_dict[i] = climb_stairs(i + 1, n, m_dict) + climb_stairs(i + 2, n, m_dict)
            return m_dict[i]
        
        return climb_stairs(0, n, {})

