class Solution:
    def minDiffInBST(self, root) -> int:
        # 取值2-100之间
        diff = 100
        last = -100
        stack = []
        node = root
        while stack or node:
            if node.left:
                stack.append(node)
                node = node.left
                continue

            while stack or node:
                diff = min(diff, node.val - last)
                last = node.val
                if node.right:
                    node = node.right
                    break
                if stack:
                    node = stack.pop()
                else:
                    node = None

        return diff
