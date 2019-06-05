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
        self.ret = self.preVal = 1 << 31

        def dfs(node):
            if self.ret == 1:
                return
            if not node:
                return
            dfs(node.left)
            self.ret = min(abs(node.val - self.preVal), self.ret)
            self.preVal = node.val
            dfs(node.right)
            
        dfs(root)
        return self.ret
