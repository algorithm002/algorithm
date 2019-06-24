class Solution:
    def isSymmetric(self, root):
        if not root:
            return True
        stack = [root.left, root.right]
        while stack:
            n1 = stack.pop()
            n2 = stack.pop()

            if not n1 and not n2:
                continue
            if not n1 or not n2:
                return False
            if n1.val != n2.val:
                return False

            stack.append(n1.left)
            stack.append(n2.right)
            stack.append(n1.right)
            stack.append(n2.left)
        return True
