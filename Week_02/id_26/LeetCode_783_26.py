#
# @lc app=leetcode.cn id=783 lang=python
#
# [783] 二叉搜索树结点最小距离
#
# https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/description/
#
# algorithms
# Easy (51.59%)
# Likes:    24
# Dislikes: 0
# Total Accepted:    3.2K
# Total Submissions: 6.2K
# Testcase Example:  '[4,2,6,1,3,null,null]'
#
# 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
#
# 示例：
#
#
# 输入: root = [4,2,6,1,3,null,null]
# 输出: 1
# 解释:
# 注意，root是树结点对象(TreeNode object)，而不是数组。
#
# 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
#
# ⁠         4
# ⁠       /   \
# ⁠     2      6
# ⁠    / \
# ⁠   1   3
#
# 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
#
# 注意：
#
#
# 二叉树的大小范围在 2 到 100。
# 二叉树总是有效的，每个节点的值都是整数，且不重复。
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
    def minDiffInBST(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.ans = 31 << 1
        self.last = -31 << 1

        def dfs(root):
            if not root:
                return
            if root.left:
                dfs(root.left)
            self.ans = min(self.ans, root.val - self.last)
            self.last = root.val
            if root.right:
                dfs(root.right)

        dfs(root)
        return self.ans
