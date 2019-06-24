#
# @lc app=leetcode.cn id=103 lang=python
#
# [103] 二叉树的锯齿形层次遍历
#
# https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/description/
#
# algorithms
# Medium (49.74%)
# Likes:    64
# Dislikes: 0
# Total Accepted:    11.7K
# Total Submissions: 23.5K
# Testcase Example:  '[3,9,20,null,null,15,7]'
#
# 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
#
# 例如：
# 给定二叉树 [3,9,20,null,null,15,7],
#
# ⁠   3
# ⁠  / \
# ⁠ 9  20
# ⁠   /  \
# ⁠  15   7
#
#
# 返回锯齿形层次遍历如下：
#
# [
# ⁠ [3],
# ⁠ [20,9],
# ⁠ [15,7]
# ]
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
    def zigzagLevelOrder(self, root):
        """
        思路：层序遍历，每隔一层换一个方向遍历
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        line, ret, rot = [root], [], 1
        while line:
            tmp1, tmp2 = [], []
            for i in line:
                if i.left:
                    tmp1.append(i.left)
                if i.right:
                    tmp1.append(i.right)
            for j in line[::rot]:
                tmp2.append(j.val)
            ret.append(tmp2)
            line = tmp1
            rot *= -1
        return ret
