"""
似乎是最优解 时间O(n) 空间O(1)
投票法
假设一个数是众数 在遍历过程中遇到该数则投票+1，不是该数则-1。
如果票数为0，则从新开始投票，并将下一个数设为架设众数。
因为众数多于一半，所以最终一定会耗尽其他数的票数并最终占有票数
"""


class Solution:
    def majorityElement(self, nums):
        vote = 0
        for n in nums:
            if vote == 0:
                result = n
                vote += 1
                continue
            if result == n:
                vote += 1
            else:
                vote -= 1

        return result
