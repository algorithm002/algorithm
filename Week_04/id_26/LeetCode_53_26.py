#
# @lc app=leetcode.cn id=53 lang=python
#
# [53] 最大子序和
#
# https://leetcode-cn.com/problems/maximum-subarray/description/
#
# algorithms
# Easy (45.36%)
# Likes:    995
# Dislikes: 0
# Total Accepted:    64.5K
# Total Submissions: 141.4K
# Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
#
# 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
#
# 示例:
#
# 输入: [-2,1,-3,4,-1,2,1,-5,4],
# 输出: 6
# 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
#
#
# 进阶:
#
# 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
#
#


class Solution(object):
    def maxSubArray1(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        解法1：动态规划，dp[i]表示包含i的最大连续子数组和
        """
        dp = [i for i in nums]
        for i in range(1, len(nums)):
            dp[i] = max(dp[i-1], 0) + nums[i]
        return max(dp)

    def maxSubArray(self, nums):
        """
        解法2：跟动态规划的思路类似，只需要记录包含当前节点的最大子数组和
        """
        ret, _max = nums[0], nums[0]
        for i in range(1, len(nums)):
            _max = max(_max, 0) + nums[i]
            ret = max(ret, _max)
        return ret


print(Solution().maxSubArray1([1]))
print(Solution().maxSubArray1([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
