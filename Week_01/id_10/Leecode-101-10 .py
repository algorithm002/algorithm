# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        return self._dfs(root.left, root.right)

    def _dfs(self, node1, node2):
        if not node1 and node2 or not node2 and node1:
            return False
        if node1 and node2 and node1.val != node2.val:
            return False
        if not node1 and not node2:
            return True
        return self._dfs(node1.left, node2.right) and self._dfs(node2.left, node1.right)
