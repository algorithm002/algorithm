#
# @lc app=leetcode.cn id=169 lang=python
#
# [169] 求众数
#
# https://leetcode-cn.com/problems/majority-element/description/
#
# algorithms
# Easy (59.48%)
# Likes:    261
# Dislikes: 0
# Total Accepted:    49.3K
# Total Submissions: 82.6K
# Testcase Example:  '[3,2,3]'
#
# 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
#
# 你可以假设数组是非空的，并且给定的数组总是存在众数。
#
# 示例 1:
#
# 输入: [3,2,3]
# 输出: 3
#
# 示例 2:
#
# 输入: [2,2,1,1,1,2,2]
# 输出: 2
#
#
#


class Solution(object):
    def majorityElement1(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        解法1：排序
        """
        nums.sort()
        return nums[len(nums)//2]

    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        解法2: 递归+分治
        分治问题模板步骤：
        1.结束条件
        2.拆分子问题
        3.递归处理子问题
        4.处理子问题的结果
        """
        def helper(left, right):

            if left == right:
                return nums[left]

            mid = (right+left) // 2

            leftNum = helper(left, mid)
            rightNum = helper(mid+1, right)

            if leftNum == rightNum:
                return leftNum
            leftCount, rightCount = 0, 0
            for i in range(left, right+1):
                if nums[i] == leftNum:
                    leftCount += 1
                elif nums[i] == rightNum:
                    rightCount += 1
            return leftNum if leftCount >= rightCount else rightNum

        return helper(0, len(nums)-1)


# print(Solution().majorityElement([1, 2, 1, 3, 1, 2, 1]))
