"""
一时没太想到分治咋整，先按我最朴素的思路试试。
行列都是升序，只要分别在行列中找到小于等于目标值的下标，然后访问判断即可。
====我想错了 还是换回分治琢磨琢磨

我懂了，目前的思路是，尝试把矩阵先分成2份, 先行后列，每份最大值和最小值都容易确定。然后分治并剪除不符合要求的矩阵
"""


class Solution:
    def searchMatrix(self, matrix, target):
        if not matrix or not matrix[0]:
            return False
        return self.division(matrix, target)

    def division(self, matrix, target):
        if not matrix or not matrix[0]:
            return False

        if matrix[0][0] == target:
            return True

        rows = len(matrix)
        cols = len(matrix[0])
        if matrix[0][0] > target or target > matrix[rows-1][cols-1]:
            return False

        if rows > 1:
            index = rows//2
            return self.division(matrix[:index], target) or self.division(matrix[index:], target)
        else:
            index = cols//2
            return self.division([matrix[0][:index]], target) or self.division([matrix[0][index:]], target)


s = Solution()
matrix = [
    [1,   4,  7, 11, 15],
    [2,   5,  8, 12, 19],
    [3,   6,  9, 16, 22],
    [10, 13, 14, 17, 24],
    [18, 21, 23, 26, 30]
]

print(s.searchMatrix(matrix, 5))
print(s.searchMatrix(matrix, 20))
