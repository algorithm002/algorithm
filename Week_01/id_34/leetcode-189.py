from typing import List


class Solution:
    # 重伤, 提交代码说是执行时间过长 43333333
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)

        if n == 0 or n == 1:
            return

        if k > n:
            k = k % n

        for i in range(k):
            temp = nums[n - 1]
            for j in range(n - 1, 0, -1):
                nums[j] = nums[j - 1]
            nums[0] = temp

    # 和上面一样, 180 ms, 13.5 MB
    def rotate2(self, nums: List, k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)

        if n == 0 or n == 1:
            return

        if k > n:
            k = k % n

        for _ in range(k):
            nums.insert(0, nums.pop())

    # 反转法, 72 ms, 13.2 MB
    def rotate3(self, nums: List, k: int) -> None:
        n = len(nums)

        if n == 0 or n == 1:
            return

        if k > n:
            k = k % n

        self.reverse(nums=nums, s=0, end=n-1)
        self.reverse(nums=nums, s=0, end=k-1)
        self.reverse(nums=nums, s=k, end=n-1)

    def reverse(self, nums: List, s: int, end: int):
        while end > s:
            nums[end], nums[s] = nums[s], nums[end]
            end -= 1
            s += 1

    # 根据索引, 64 ms, 13.2 MB
    def rotate4(self, nums: List, k: int) -> None:
        n = len(nums)

        if n == 0 or n == 1:
            return

        if k > n:
            k = k % n

        nums[:] = nums[-k:] + nums[:-k]