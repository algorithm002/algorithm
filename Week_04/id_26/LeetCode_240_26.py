#
# @lc app=leetcode.cn id=240 lang=python
#
# [240] 搜索二维矩阵 II
#
# https://leetcode-cn.com/problems/search-a-2d-matrix-ii/description/
#
# algorithms
# Medium (36.82%)
# Likes:    111
# Dislikes: 0
# Total Accepted:    17.8K
# Total Submissions: 48.2K
# Testcase Example:  '[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n5'
#
# 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
#
#
# 每行的元素从左到右升序排列。
# 每列的元素从上到下升序排列。
#
#
# 示例:
#
# 现有矩阵 matrix 如下：
#
# [
# ⁠ [1,   4,  7, 11, 15],
# ⁠ [2,   5,  8, 12, 19],
# ⁠ [3,   6,  9, 16, 22],
# ⁠ [10, 13, 14, 17, 24],
# ⁠ [18, 21, 23, 26, 30]
# ]
#
#
# 给定 target = 5，返回 true。
#
# 给定 target = 20，返回 false。
#
#


class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        思路：从左下角开始，相等直接返回
             若大于目标值，则不可能在这一列，指针向左
             若小于目标值，则不可能在这一排，指针向上
        时间复杂度O(m+n)
        """
        if not matrix or not matrix[0]:
            return False
        m, n = len(matrix)-1, 0

        while m >= 0 and n < len(matrix[0]):
            if matrix[m][n] == target:
                return True
            if matrix[m][n] < target:
                n += 1
            else:
                m -= 1
        return False


# print(Solution().searchMatrix([[1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [
    #   3, 6, 9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26, 30]], 333))
