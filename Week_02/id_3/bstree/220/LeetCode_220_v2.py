"""
暴力解法时间复杂度 O(kn) 似乎实现没什么难度，但是想必无法通过测试
但是上一个解法python实现效率太差了，试试暴力行不行
"""


class Solution:
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        if k > t:
            return self.tn(nums, k, t)
        else:
            return self.kn(nums, k, t)

    def tn(self, nums, k, t):
        m = {}
        for i in range(len(nums)):
            v = nums[i]
            for j in range(-t, t + 1):
                if (v+j) in m and k >= (i - m[v+j]):
                    return True
            m[v] = i
        return False

    def kn(self, nums, k, t):
        length = len(nums)
        if k > length:
            k = length - 1
        for i in range(length):
            v = nums[i]
            for p in range(1, k + 1):
                index = i + p
                if index == length:
                    break
                if t >= abs(v - nums[index]):
                    return True

        return False


s = Solution()

print(s.containsNearbyAlmostDuplicate([1, 2, 3, 1], 3, 0))
print(s.containsNearbyAlmostDuplicate([1, 0, 1, 1], 1, 2))
print(s.containsNearbyAlmostDuplicate([1, 5, 9, 1, 5, 9], 2, 3))
print(s.containsNearbyAlmostDuplicate([4, 1, 6, 3], 100, 1))
print(s.containsNearbyAlmostDuplicate([7, 1, 3], 2, 3))
print(s.containsNearbyAlmostDuplicate([7, 2, 8], 2, 1))
print(s.containsNearbyAlmostDuplicate([2, 0, -2, 2], 2, 1))
