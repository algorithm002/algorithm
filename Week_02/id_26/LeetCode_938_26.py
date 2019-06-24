#
# @lc app=leetcode.cn id=938 lang=python
#
# [938] 二叉搜索树的范围和
#
# https://leetcode-cn.com/problems/range-sum-of-bst/description/
#
# algorithms
# Easy (74.72%)
# Likes:    39
# Dislikes: 0
# Total Accepted:    4.8K
# Total Submissions: 6.4K
# Testcase Example:  '[10,5,15,3,7,null,18]\n7\n15'
#
# 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
#
# 二叉搜索树保证具有唯一的值。
#
#
#
# 示例 1：
#
# 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
# 输出：32
#
#
# 示例 2：
#
# 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
# 输出：23
#
#
#
#
# 提示：
#
#
# 树中的结点数量最多为 10000 个。
# 最终的答案保证小于 2^31。
#
#
#
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def rangeSumBST(self, root, L, R):
        """
        :type root: TreeNode
        :type L: int
        :type R: int
        :rtype: int
        """
        self.ans = 0

        def _rangeSumBST(root):
            if not root:
                return
            if root.val > L:
                _rangeSumBST(root.left)
            if L <= root.val <= R:
                self.ans += root.val
            if root.val < R:
                _rangeSumBST(root.right)

        _rangeSumBST(root)
        return self.ans
