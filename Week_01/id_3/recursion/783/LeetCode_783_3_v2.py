class Solution:
    def minDiffInBST(self, root) -> int:
        # 取值2-100之间
        self.diff = 100
        self.last = -100

        def dfs(node):
            if not node:
                return
            dfs(node.left)
            self.diff = min(self.diff, node.val-self.last)
            self.last = node.val
            dfs(node.right)

        dfs(root)
        return self.diff
