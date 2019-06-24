class MedianFinder:
    """
        尝试跳表实现
    """

    def __init__(self):
        pass

    def addNum(self, num: int) -> None:
        pass

    def findMedian(self) -> float:
        pass


s = MedianFinder()
s.addNum(1)
s.addNum(2)
print(s.findMedian(), s.findMedian() == 1.5)
s.addNum(3)
print(s.findMedian(), s.findMedian() == 2)
