class Solution:
    def isValidBST(self, root):
        """
            递归
        """
        if not root:
            return True

        return self.min_max(root)[0]

    def min_max(self, node):
        if not node.left and not node.right:
            return [True, node.val, node.val]

        result = [True, None, None]
        if node.left:
            r = self.min_max(node.left)
            if not r[0] or r[2] >= node.val:
                return [False]
            result[1] = r[1]
        else:
            result[1] = node.val

        if node.right:
            r = self.min_max(node.right)
            if not r[0] or r[1] <= node.val:
                return [False]
            result[2] = r[2]
        else:
            result[2] = node.val

        return result
