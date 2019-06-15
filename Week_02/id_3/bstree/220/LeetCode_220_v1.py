"""
暴力解法时间复杂度 O(kn) 似乎实现没什么难度，但是想必无法通过测试
目前的思路是 维护一个空间为k的bst做为窗口 只要bst中距离目标值最近的元素绝对值小于等于t 即可返回True
在迭代数组的时候，对bst进行增与删的维护
由于python似乎没有bst的数据结构，所以使用一个排序数组替代实现
"""


class Solution:
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        if not nums:
            return False
        if k == 0:
            return False
        if t < 0:
            return False

        length = len(nums)

        if k > length:
            k = length

        if length == 1:
            return False

        sort_list = [nums[0]]
        for i in range(1, length):
            v = nums[i]
            p = self.position(sort_list, v)
            if sort_list[p] == v:
                return True

            # 这里想写的优雅还挺难 边界处理起来很复杂
            if t >= abs(sort_list[p]-v):
                return True
            if sort_list[p] > v:
                if p >= 0 and t >= abs(sort_list[p - 1]-v):
                    return True
            else:
                if (p+1) < len(sort_list) and t >= abs(sort_list[p + 1]-v):
                    return True

            if i < k:
                self.insert(sort_list, p, v)
                continue

            need_pop = nums[i-k]
            if need_pop == v:
                continue
            else:
                self.insert(sort_list, p, v)
                sort_list.pop(self.position(sort_list, need_pop))
        return False

    def insert(self, sort_list, p, v):
        if sort_list[p] > v:
            sort_list.insert(p, v)
        else:
            sort_list.insert(p + 1, v)

    def position(self, sort_list, v):
        low = 0
        high = len(sort_list) - 1
        while low <= high:
            mid = low + int((high - low)/2)
            if sort_list[mid] == v:
                return mid
            if sort_list[mid] > v:
                high = mid - 1
            else:
                low = mid + 1

        return mid


s = Solution()

print(s.containsNearbyAlmostDuplicate([1, 2, 3, 1], 3, 0))
print(s.containsNearbyAlmostDuplicate([1, 0, 1, 1], 1, 2))
print(s.containsNearbyAlmostDuplicate([1, 5, 9, 1, 5, 9], 2, 3))
print(s.containsNearbyAlmostDuplicate([4, 1, 6, 3], 100, 1))
