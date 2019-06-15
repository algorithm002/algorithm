class Solution:
    def rangeSumBST(self, root, l, r):
        return self.dfs(root, l, r)

    def dfs(self, node, l, r):
        if not node:
            return 0

        if node.val < l:
            return self.dfs(node.right, l, r)

        if node.val > r:
            return self.dfs(node.left, l, r)

        return self.dfs(node.left, l, r) + node.val + self.dfs(node.right, l, r)
