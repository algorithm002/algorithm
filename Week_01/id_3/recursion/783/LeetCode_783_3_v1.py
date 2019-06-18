class Solution:
    def minDiffInBST(self, root) -> int:
        if not root:
            return 0
        stack = []
        node = root
        # 题目中有说明取值在 2 - 100
        diff = 99
        last = -100
        while stack or node:
            if node:
                stack.append(node)
                node = node.left
            else:
                node = stack.pop()
                diff = min(diff, node.val - last)
                last = node.val
                node = node.right

        return diff
