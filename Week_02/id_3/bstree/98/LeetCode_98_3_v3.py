class Solution:
    def isValidBST(self, root):
        """
            bst定义
            左子树都比节点小
            右子树都比节点大
            并且所有子树都一样
        """
        return self.valid(root, None, None)

    def valid(self, node, left, right):
        if not node:
            return True
        if left is not None and left >= node.val:
            return False
        if right is not None and right <= node.val:
            return False

        return self.valid(node.left, left, node.val) and self.valid(node.right, node.val, right)
