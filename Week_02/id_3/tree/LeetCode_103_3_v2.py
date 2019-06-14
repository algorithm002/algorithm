class Solution:
    def zigzagLevelOrder(self, root):
        r = []
        if not root:
            return r
        queue = [root]
        while queue:
            r.append(queue)
            need_reverse = len(r) % 2 == 0
            _queue = []

            if need_reverse:
                rg = range(len(queue) - 1, -1, -1)
            else:
                rg = range(len(queue))

            for i in rg:
                node = queue[i]
                queue[i] = node.val
                if need_reverse:
                    if node.left:
                        _queue.append(node.left)
                    if node.right:
                        _queue.append(node.right)
                else:
                    if node.left:
                        _queue.insert(0, node.left)
                    if node.right:
                        _queue.insert(0, node.right)

            queue = _queue

        return r
