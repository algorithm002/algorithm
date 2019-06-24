"""
参考高人的写法 震惊

如果abs(n1, n2) <= t
那么 abs(n1//t - n2//t) <= 1

数字 n 只需要在缓存中查找 n//t-1, n//t, n//t+1 (以下记为 m1, m2, m3) 三个对应的数据即可找到是否有符合条件的数据存在。
n如果存在满足条件的目标答案，必然会首先出现在 m1, m2, m3所对应的数据中。
nums中可能存在多个数据与m123映射，其中可能存在符合条件与不符合条件的数据，
但当迭代到n时，m123必然不会出现曾经有效的数据被无效数据覆盖的情况。
例如m3对应n3_1与n3_2两个值，其中abs(n3_1-n)<=t, abs(n3_2-n)>t，如果存在这种情况，当数据遍历至n3_2时即可返回True，不会迭代至n。
缓存维护k个数据即可满足下标不超过k的条件。

整体时间复杂度O(n) 神了 跪下了
"""


class Solution:
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        if not nums:
            return False
        if k == 0:
            return False
        if t < 0:
            return False

        m = {}
        length = len(nums)
        if k > length:
            k = length - 1

        for i in range(length):
            v = nums[i]

            key = v if not t else v//t

            for j in (-1, 0, 1):
                x = m.get(key + j, None)
                if x is None:
                    continue
                if t >= abs(x - v):
                    return True

            if i >= k:
                m.pop(nums[i-k] if not t else nums[i-k]//t)

            m[key] = v

        return False


s = Solution()

print(s.containsNearbyAlmostDuplicate([1, 2, 3, 1], 3, 0))
print(s.containsNearbyAlmostDuplicate([1, 0, 1, 1], 1, 2))
print(s.containsNearbyAlmostDuplicate([1, 5, 9, 1, 5, 9], 2, 3))
print(s.containsNearbyAlmostDuplicate([4, 1, 6, 3], 100, 1))
print(s.containsNearbyAlmostDuplicate([7, 1, 3], 2, 3))
print(s.containsNearbyAlmostDuplicate([7, 2, 8], 2, 1))
print(s.containsNearbyAlmostDuplicate([2, 0, -2, 2], 2, 1))
