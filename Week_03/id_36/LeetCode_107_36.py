#
# @lc app=leetcode.cn id=107 lang=python3
#
# [107] 二叉树的层次遍历 II
#
# https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
#
# algorithms
# Easy (60.90%)
# Likes:    108
# Dislikes: 0
# Total Accepted:    17.6K
# Total Submissions: 28.9K
# Testcase Example:  '[3,9,20,null,null,15,7]'
#
# 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
# 
# 例如：
# 给定二叉树 [3,9,20,null,null,15,7],
# 
# ⁠   3
# ⁠  / \
# ⁠ 9  20
# ⁠   /  \
# ⁠  15   7
# 
# 
# 返回其自底向上的层次遍历为：
# 
# [
# ⁠ [15,7],
# ⁠ [9,20],
# ⁠ [3]
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

# BFS
class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        levels = []
        if not root:
            return levels
        
        from collections import deque
        queue = deque([root,])
        children_list = []

        while queue:
            level_length = len(queue)

            for i in range(level_length):
                node = queue.popleft()

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                
                children_list.append(node.val)

            levels.insert(0, children_list)
            children_list = []
        
        return levels

