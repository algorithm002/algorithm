class Solution:
    def minDepth(self, root) -> int:
        if root is None:
            return 0

        self.level = None
        self.dfs(root, 0)
        return self.level

    def dfs(self, node, level):
        if not node:
            return
        level += 1
        if self.level and self.level <= level:
            return
        if not node.left and not node.right:
            self.level = level
            return

        self.dfs(node.left, level)
        self.dfs(node.right, level)
