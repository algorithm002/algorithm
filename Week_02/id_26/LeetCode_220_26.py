#
# @lc app=leetcode.cn id=220 lang=python
#
# [220] 存在重复元素 III
#
# https://leetcode-cn.com/problems/contains-duplicate-iii/description/
#
# algorithms
# Medium (24.08%)
# Likes:    63
# Dislikes: 0
# Total Accepted:    5.1K
# Total Submissions: 20.9K
# Testcase Example:  '[1,2,3,1]\n3\n0'
#
# 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j
# 之间的差的绝对值最大为 ķ。
#
# 示例 1:
#
# 输入: nums = [1,2,3,1], k = 3, t = 0
# 输出: true
#
# 示例 2:
#
# 输入: nums = [1,0,1,1], k = 1, t = 2
# 输出: true
#
# 示例 3:
#
# 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
# 输出: false
#
#


class Solution(object):
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        """
        :type nums: List[int]
        :type k: int
        :type t: int
        :rtype: bool
        解法1：暴力求解，复杂度O(n*k)，容易超时，最后一个用例过不了。面向用例编程 - -。真的香
        """
        if not nums:
            return False
        n = len(nums)
        wins = set()
        for i in range(n):
            if t == 0:
                if nums[i] in wins:
                    return True
            else:
                for v in wins:
                    if abs(nums[i] - v) <= t:
                        return True
            wins.add(nums[i])
            if len(wins) == k + 1:
                wins.remove(nums[i - k])
        return False

    def containsNearbyAlmostDuplicate2(self, nums, k, t):
        """
        :type nums: List[int]
        :type k: int
        :type t: int
        :rtype: bool
        解法2：来自https://leetcode.com/problems/contains-duplicate-iii/discuss/61756/Python-OrderedDict
        证明=》
        如果： | nums[i] - nums[j] | <= t 式a
        等价： | nums[i] / t - nums[j] / t | <= 1 式b
        推出： | floor(nums[i] / t) - floor(nums[j] / t) | <= 1 式c
        ​等价： floor(nums[j] / t) ∈ {floor(nums[i] / t) - 1, floor(nums[i] / t), floor(nums[i] / t) + 1} 式d
        其中式b是式c的充分非必要条件，因为逆否命题与原命题等价，所以：
        如果： floor(nums[j] / t) ∉ {floor(nums[i] / t) - 1, floor(nums[i] / t), floor(nums[i] / t) + 1} 非d
        推出： | nums[i] - nums[j] | > t 非a
        """
        import collections
        if k < 1 or t < 0:
            return False
        dic = collections.OrderedDict()
        for n in nums:
            key = n if not t else n // t
            for m in (dic.get(key - 1), dic.get(key), dic.get(key + 1)):
                if m is not None and abs(n - m) <= t:
                    return True
            if len(dic) == k:
                dic.popitem(False)
            dic[key] = n
        return False


     def containsNearbyAlmostDuplicate3(self, nums, k, t):   
        if t < 0:
            return False
        cache = {}
        for i in range(len(nums)):
            if i - k > 0:
                bucket_id_to_delete = nums[i - k - 1] // (t + 1)
                del cache[bucket_id_to_delete]
            bucket_id = nums[i] // (t + 1)
            condition1 = (bucket_id in cache)
            condition2 = ((bucket_id - 1 in cache
                           and abs(cache[bucket_id - 1] - nums[i]) <= t))
            condition3 = ((bucket_id + 1 in cache
                           and abs(cache[bucket_id + 1] - nums[i]) <= t))
            if condition1 or condition2 or condition3:
                return True
            cache[bucket_id] = nums[i]
        return False


# print(Solution().containsNearbyAlmostDuplicate([1, 2, 3, 1], 3, 0))
# print(Solution().containsNearbyAlmostDuplicate([1, 0, 1, 1], 1, 2))
# print(Solution().containsNearbyAlmostDuplicate([1, 5, 9, 1, 5, 9], 2, 3))
# print(Solution().containsNearbyAlmostDuplicate([2, 2], 3, 0))
