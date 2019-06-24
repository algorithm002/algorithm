#
# @lc app=leetcode.cn id=101 lang=python3
#
# [101] 对称二叉树
#
# https://leetcode-cn.com/problems/symmetric-tree/description/
#
# algorithms
# Easy (46.79%)
# Likes:    357
# Dislikes: 0
# Total Accepted:    36K
# Total Submissions: 77K
# Testcase Example:  '[1,2,2,3,4,4,3]'
#
# 给定一个二叉树，检查它是否是镜像对称的。
# 
# 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
# 
# ⁠   1
# ⁠  / \
# ⁠ 2   2
# ⁠/ \ / \
# 3  4 4  3
# 
# 
# 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
# 
# ⁠   1
# ⁠  / \
# ⁠ 2   2
# ⁠  \   \
# ⁠  3    3
# 
# 
# 说明:
# 
# 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
# 
#
# Definition for a binary tree node.


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# # 递归
# class Solution:
#     def isSymmetric(self, root: TreeNode) -> bool:
#         return self.isMirror(root, root)

#     def isMirror(self, root1: TreeNode, root2: TreeNode) -> bool:
#         if root1 is None and root2 is None:
#             return True
#         if root1 is None or root2 is None:
#             return False
        
#         return root1.val == root2.val and self.isMirror(root1.right, root2.left) and self.isMirror(root1.left, root2.right)

# 迭代
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        queue = []
        queue.append(root)
        queue.append(root)

        while len(queue) > 0:
            t1 = queue.pop()
            t2 = queue.pop()
            if t1 is None and t2 is None:
                continue
            if t1 is None or t2 is None:
                return False
            if t1.val != t2.val:
                return False
            
            queue.append(t1.left)
            queue.append(t2.right)
            queue.append(t1.right)
            queue.append(t2.left)
        
        return True

