#
# @lc app=leetcode.cn id=104 lang=python3
#
# [104] 二叉树的最大深度
#
# https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/
#
# algorithms
# Easy (69.37%)
# Likes:    298
# Dislikes: 0
# Total Accepted:    52.1K
# Total Submissions: 75.1K
# Testcase Example:  '[3,9,20,null,null,15,7]'
#
# 给定一个二叉树，找出其最大深度。
# 
# 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
# 
# 说明: 叶子节点是指没有子节点的节点。
# 
# 示例：
# 给定二叉树 [3,9,20,null,null,15,7]，
# 
# ⁠   3
# ⁠  / \
# ⁠ 9  20
# ⁠   /  \
# ⁠  15   7
# 
# 返回它的最大深度 3 。
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
#     def maxDepth(self, root: TreeNode) -> int:
#         if not root:
#             return 0
#         return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1

# DFS
class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if root is None:
            return 0
        
        stack = []
        stack.append((root, 1))
        max_depth = 0
        while len(stack) > 0:
            current = stack.pop()
            root = current[0]
            current_depth = current[1]
            if root.left is None and root.right is None:
                max_depth = max(max_depth, current_depth)
            if root.left is not None:
                stack.append((root.left, current_depth + 1))
            if root.right is not None:
                stack.append((root.right, current_depth + 1))
        
        return max_depth
