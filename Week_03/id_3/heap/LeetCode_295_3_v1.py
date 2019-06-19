import heapq


class MedianFinder:
    """
        用最大最小双堆实现
    """

    def __init__(self):
        self.min_heap = []
        self.max_heap = []

    def addNum(self, num: int) -> None:
        # >= 其实不是最优的写法 但是大差不差 理论上如果存在相等的值，可以判断哪个堆数量少
        # 优雅的写法不是最高效的，但是可以忽略不计
        if not self.min_heap or -num >= self.min_heap[0]:
            heapq.heappush(self.min_heap, -num)
        else:
            heapq.heappush(self.max_heap, num)
        if abs(len(self.min_heap) - len(self.max_heap)) == 2:
            if len(self.min_heap) > len(self.max_heap):
                heapq.heappush(self.max_heap, -heapq.heappop(self.min_heap))
            else:
                heapq.heappush(self.min_heap, -heapq.heappop(self.max_heap))

    def findMedian(self) -> float:
        if not self.min_heap and not self.max_heap:
            return None
        if len(self.min_heap) == len(self.max_heap):
            return (-self.min_heap[0] + self.max_heap[0])/2
        if len(self.min_heap) > len(self.max_heap):
            return -self.min_heap[0]
        else:
            return self.max_heap[0]


s = MedianFinder()
s.addNum(1)
s.addNum(2)
print(s.findMedian(), s.findMedian() == 1.5)
s.addNum(3)
print(s.findMedian(), s.findMedian() == 2)
s.addNum(0)
print(s.findMedian(), s.findMedian() == 1.5)
s.addNum(9)
print(s.findMedian(), s.findMedian() == 2)
s.addNum(6)
print(s.findMedian(), s.findMedian() == 2.5)
s.addNum(7)
print(s.findMedian(), s.findMedian() == 3)
