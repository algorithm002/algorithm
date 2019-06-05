# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def rangeSumBST(self, root, L, R):
        """
        :type root: TreeNode
        :type L: int
        :type R: int
        :rtype: int
        """
        self.ret = 0

        def bst(root, L, R):
            if not root:
                return
            bst(root.left, L, R)
            if root.val <= R and root.val >= L:
                self.ret += root.val
            bst(root.right, L, R)
        bst(root, L, R)
        return self.ret

    def rangeSumBST2(self, root, L, R):
        """
        :type root: TreeNode
        :type L: int
        :type R: int
        :rtype: int
        """
        def dfs(node):
            if not node:
                return
            if L <= node.val <= R:
                self.ans += node.val
            if L < node.val:
                dfs(node.left)
            if node.val < R:
                dfs(node.right)

        self.ans = 0
        dfs(root)
        return self.ans
