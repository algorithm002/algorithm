# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or not p and not q:
            return None
        if root==p or root==q:
            return root
        leftTree=self.lowestCommonAncestor(root.left,p,q)
        rightTree=self.lowestCommonAncestor(root.right,p,q)
        if not leftTree and not rightTree:
            return None
        if leftTree and rightTree:
            return root
        if leftTree:
            return leftTree
        return rightTree