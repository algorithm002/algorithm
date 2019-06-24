#
# @lc app=leetcode.cn id=295 lang=python
#
# [295] 数据流的中位数
#
# https://leetcode-cn.com/problems/find-median-from-data-stream/description/
#
# algorithms
# Hard (35.43%)
# Likes:    46
# Dislikes: 0
# Total Accepted:    3.3K
# Total Submissions: 9.2K
# Testcase Example:  '["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]\n[[],[1],[2],[],[3],[]]'
#
# 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
#
# 例如，
#
# [2,3,4] 的中位数是 3
#
# [2,3] 的中位数是 (2 + 3) / 2 = 2.5
#
# 设计一个支持以下两种操作的数据结构：
#
#
# void addNum(int num) - 从数据流中添加一个整数到数据结构中。
# double findMedian() - 返回目前所有元素的中位数。
#
#
# 示例：
#
# addNum(1)
# addNum(2)
# findMedian() -> 1.5
# addNum(3)
# findMedian() -> 2
#
# 进阶:
#
#
# 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
# 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
#
# 
#
"""
维护大顶堆、小顶堆，满足以下条件：

大顶堆中数字的个数 - 小顶堆数字的个数 = 0 or 1
大顶堆的最大值 <= 小顶堆的最小值
当长度为偶数时，中位数为大小顶堆的平均数 当长度为奇数时，中位数为大顶堆的最大值

注：python的heapq中只有小顶堆，所以存入时取负数则为大顶堆
"""
import heapq


class MedianFinder(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.len = 0
        self.max_heap, self.min_heap = [], []

    def addNum(self, num):
        """
        :type num: int
        :rtype: None
        """
        self.len += 1
        heapq.heappush(self.min_heap, -heapq.heappushpop(self.max_heap, num))
        if len(self.min_heap) > len(self.max_heap):
            heapq.heappush(self.max_heap, -heapq.heappop(self.min_heap))

    def findMedian(self):
        """
        :rtype: float
        """
        if self.len & 1 == 0:
            return (self.max_heap[0] - self.min_heap[0]) / 2.0
        return self.max_heap[0]
