class KthLargest(object):
    
    def __init__(self, k, nums):
        """
        :type k: int
        :type nums: List[int]
        """
        self.k = k
        self.nums = nums
        self.nums.sort()
        self.nums_len = len(self.nums)
        self.kNums = self.nums[:] if self.nums_len < self.k else self.nums[self.nums_len - self.k : self.nums_len : 1]
        

    def add(self, val):
        """
        :type val: int
        :rtype: int
        """
        self.kNums.append(val)
        self.kNums.sort()
        if len(self.kNums) > self.k:
            self.kNums.pop(0)
        return self.kNums[0]
        


# Your KthLargest object will be instantiated and called as such:
k = 3
nums = [5,-1]
val = 2

print(KthLargest(k, nums).add(val))