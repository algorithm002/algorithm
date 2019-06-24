import heapq


class KthLargest:

    def __init__(self, k: int, nums):
        self.heap = []
        self.k = k
        for v in nums:
            self.add(v)

    def add(self, val: int):
        if len(self.heap) < self.k:
            heapq.heappush(self.heap, val)
        elif val > self.heap[0]:
            heapq.heapreplace(self.heap, val)

        return self.heap[0]


kthLargest = KthLargest(3, [4, 5, 8, 2])
print(kthLargest.add(3) == 4)
print(kthLargest.add(5) == 5)
print(kthLargest.add(10) == 5)
print(kthLargest.add(9) == 8)
print(kthLargest.add(4) == 8)

h = heapq.nlargest(3, [1, 2, 3, 4, 5])
heapq.heappush(h, 9)
print(h)

