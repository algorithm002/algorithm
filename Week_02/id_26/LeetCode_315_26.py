#
# @lc app=leetcode.cn id=315 lang=python
#
# [315] 计算右侧小于当前元素的个数
#
# https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/description/
#
# algorithms
# Hard (37.52%)
# Likes:    63
# Dislikes: 0
# Total Accepted:    2.9K
# Total Submissions: 7.8K
# Testcase Example:  '[5,2,6,1]'
#
# 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于
# nums[i] 的元素的数量。
#
# 示例:
#
# 输入: [5,2,6,1]
# 输出: [2,1,1,0]
# 解释:
# 5 的右侧有 2 个更小的元素 (2 和 1).
# 2 的右侧仅有 1 个更小的元素 (1).
# 6 的右侧有 1 个更小的元素 (1).
# 1 的右侧有 0 个更小的元素.
#
#
# 思路： 构建一个二叉搜索树，左子树小于等于根节点，右子树大于根节点
#       节点内记录下标，所有左节点的个数，以及右侧小于该节点的总数
#       若插入节点小于等于当前节点，则当前节点的左节点总数+1
#       若插入节点大于当前节点，则当前节点的右侧小于该节点的总数=当前节点的左节点总数+1(当前节点)
#       最后深度遍历


class BST(object):
    def __init__(self, index, val):
        self.left = None
        self.right = None
        self.index = index
        self.val = val
        # 右侧小于该节点的总数
        self.count = 0
        # 左子树总数
        self.left_count = 0

    def insert(self, node):
        if node.val <= self.val:
            self.left_count += 1
            if not self.left:
                self.left = node
            else:
                self.left.insert(node)
        else:
            node.count += self.left_count + 1
            if not self.right:
                self.right = node
            else:
                self.right.insert(node)


class Solution(object):
    def countSmaller(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if not nums:
            return []
        nums = nums[::-1]
        root = BST(0, nums[0])
        for i in range(1, len(nums)):
            root.insert(BST(i, nums[i]))
        ret = [0] * len(nums)

        def _dfs(root):
            if not root:
                return ret
            ret[root.index] = root.count
            _dfs(root.left)
            _dfs(root.right)
            return ret

        return _dfs(root)[::-1]


# print(Solution().countSmaller([5, 2, 6, 1]))
# print(Solution().countSmaller([1, 2, 7, 8, 5]))
# print(Solution().countSmaller([-1, -1]))
