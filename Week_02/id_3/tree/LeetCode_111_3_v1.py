class Solution:
    def minDepth(self, root) -> int:
        if root is None:
            return 0

        queue = [root]

        level = 0
        while queue:
            level += 1
            _queue = []
            for node in queue:
                if not node.left and not node.right:
                    return level

                if node.left:
                    _queue.append(node.left)
                if node.right:
                    _queue.append(node.right)

            queue = _queue
