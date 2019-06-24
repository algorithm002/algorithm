import heapq

class KthLargest(object):
    
    def __init__(self, k, nums):
        """
        :type k: int
        :type nums: List[int]
        """
        self.k = k
        self.heap = []
        for i in range(len(nums)):
            if i <= k - 1:
                heapq.heappush(self.heap, nums[i])
            else:
                heapq.heappushpop(self.heap, nums[i])

    def add(self, val):
        """
        :type val: int
        :rtype: int
        """
        if len(self.heap) < self.k:
            heapq.heappush(self.heap, val)
        else:
            heapq.heappushpop(self.heap, val) 
        return self.heap[0]
        


# Your KthLargest object will be instantiated and called as such:
k = 3
nums = [5,-1]
val = 2

print(KthLargest(k, nums).add(val))