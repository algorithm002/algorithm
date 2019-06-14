class Solution:
    def isValidBST(self, root):
        """
            深度优先中序遍历方案
        """
        stack = []
        node = root
        last = None
        while stack or node:
            if node:
                stack.append(node)
                node = node.left
            else:
                node = stack.pop()
                if last is None or last < node.val:
                    last = node.val
                else:
                    return False
                node = node.right

        return True
