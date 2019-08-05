"""
有点儿类似用递归模拟递推
没必要使用回溯+缓存 直接递归下钻即可拿到子节点的类似递推的结果
算是深度优先+递推 非常简单高效
击败接近100%
"""


class Solution:
    def rob(self, root) -> int:
        if not root:
            return 0
        return max(self.dfs(root))

    def dfs(self, node):
        if not node:
            return 0, 0

        l1, l2 = self.dfs(node.left)
        r1, r2 = self.dfs(node.right)

        return max(l1 + r1, l2 + r1, l1 + r2, l2 + r2), node.val + l1 + r1
