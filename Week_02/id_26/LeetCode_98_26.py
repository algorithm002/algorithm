#
# @lc app=leetcode.cn id=98 lang=python
#
# [98] 验证二叉搜索树
#
# https://leetcode-cn.com/problems/validate-binary-search-tree/description/
#
# algorithms
# Medium (26.07%)
# Likes:    204
# Dislikes: 0
# Total Accepted:    25K
# Total Submissions: 95.8K
# Testcase Example:  '[2,1,3]'
#
# 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
#
# 假设一个二叉搜索树具有如下特征：
#
#
# 节点的左子树只包含小于当前节点的数。
# 节点的右子树只包含大于当前节点的数。
# 所有左子树和右子树自身必须也是二叉搜索树。
#
#
# 示例 1:
#
# 输入:
# ⁠   2
# ⁠  / \
# ⁠ 1   3
# 输出: true
#
#
# 示例 2:
#
# 输入:
# ⁠   5
# ⁠  / \
# ⁠ 1   4
# / \
# 3   6
# 输出: false
# 解释: 输入为: [5,1,4,null,null,3,6]。
# 根节点的值为 5 ，但是其右子节点值为 4 。
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
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        解法1：当前节点的值为 左子树的最大值 and 右子树的最小值
        """

        def _isValidBST(root, min, max):
            if not root:
                return True
            if root.val >= max or root.val <= min:
                return False
            return _isValidBST(root.left, min, root.val) and _isValidBST(
                root.right, root.val, max)

        return _isValidBST(root, -1 << 32, 1 << 31)

    def isValidBST2(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        解法2：中序遍历递增
        """
        self.last = -1 << 32

        def _isValidBST(root):
            if not root:
                return True
            left = _isValidBST(root.left)
            ret = root.val > self.last
            self.last = root.val
            right = _isValidBST(root.right)
            return left and ret and right

        return _isValidBST(root)
