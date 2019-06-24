#
# @lc app=leetcode.cn id=102 lang=python3
#
# [102] 二叉树的层次遍历
#
# https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
#
# algorithms
# Medium (56.68%)
# Likes:    215
# Dislikes: 0
# Total Accepted:    29.3K
# Total Submissions: 51.7K
# Testcase Example:  '[3,9,20,null,null,15,7]'
#
# 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
# 
# 例如:
# 给定二叉树: [3,9,20,null,null,15,7],
# 
# ⁠   3
# ⁠  / \
# ⁠ 9  20
# ⁠   /  \
# ⁠  15   7
# 
# 
# 返回其层次遍历结果：
# 
# [
# ⁠ [3],
# ⁠ [9,20],
# ⁠ [15,7]
# ]
# 
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
#     def levelOrder(self, root: TreeNode) -> List[List[int]]:
#         levels = []
#         if not root:
#             return levels
        
#         def helper(node, level):
#             if len(levels) == level:
#                 levels.append([])
            
#             levels[level].append(node.val)

#             if node.left:
#                 helper(node.left, level + 1)
#             if node.right:
#                 helper(node.right, level + 1)
        
#         helper(root, 0)
#         return levels

# BFS
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        levels = []
        if not root:
            return levels
        
        level = 0
        from collections import deque
        queue = deque([root,])

        while queue:
            levels.append([])
            level_length = len(queue)

            for i in range(level_length):
                node = queue.popleft()

                levels[level].append(node.val)

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            
            level += 1
        
        return levels

