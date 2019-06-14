class Solution:
    def levelOrder(self, root):
        r = []
        if not root:
            return r
        queue = [root]
        while queue:
            _queue = []
            for i in range(len(queue)):
                node = queue[i]
                queue[i] = node.val
                if node.left:
                    _queue.append(node.left)
                if node.right:
                    _queue.append(node.right)

            r.append(queue)
            queue = _queue

        return r
