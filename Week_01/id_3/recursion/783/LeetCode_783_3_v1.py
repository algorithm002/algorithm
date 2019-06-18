class Solution:
    def minDiffInBST(self, root) -> int:
        if not root:
            return 0
        stack = []
        node = root
        diff = None
        last = None
        while stack or node:
            if node:
                stack.append(node)
                node = node.left
            else:
                node = stack.pop()
                if last:
                    if diff:
                        diff = min(diff, node.val - last)
                    else:
                        diff = node.val - last

                last = node.val
                node = node.right

        return diff
