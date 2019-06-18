class Solution:
    def lowestCommonAncestor(self, root, p, q):
        if p.val > q.val:
            p, q = q, p
        while True:
            if root.val < p.val:
                root = root.right
                continue

            if root.val > q.val:
                root = root.left
                continue

            return root
