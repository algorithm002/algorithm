"""
全排列 O(n^n) 似乎没啥悬念
====== 但是我居然没通过
两点问题
1 递归的退出条件不能忘了return
2 set在迭代到时候要小心插入和删除，还是list复制一份更为稳妥
"""


class Solution:
    def permute(self, nums):
        results = []
        if not nums:
            return results
        self.recursion([], set(nums), results)
        return results

    def recursion(self, curr, num_set, results):
        if len(num_set) == 0:
            results.append(curr)
            return

        for n in list(num_set):
            num_set.remove(n)
            self.recursion(curr + [n], num_set, results)
            num_set.add(n)


s = Solution()
print(s.permute([1, 2, 3]))
print(s.permute([6, 2, -1, 8]))
