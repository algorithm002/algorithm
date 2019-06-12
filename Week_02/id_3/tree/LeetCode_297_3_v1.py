class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Codec:

    def serialize(self, root):
        data = []
        queue = [root]
        none_count = 0
        while len(queue) != 0:
            if none_count >= len(queue):
                break
            _queue = []
            for i in range(len(queue)):
                node = queue[i]
                if not node:
                    none_count += 1
                    data.append(None)
                    continue

                none_count = 0
                data.append(node.val)
                _queue.append(node.left)
                _queue.append(node.right)
            queue = _queue
        return data[:-none_count]

    def deserialize(self, data):
        if not data:
            return None

        root = TreeNode(data[0])
        queue = [root]
        length = len(data)

        index = 1
        while len(queue) != 0:
            _queue = []
            for i in range(len(queue)):
                node = queue[i]
                # 不可思议的问题
                if not node:
                    continue
                if index >= length:
                    return root
                d = data[index]
                node.left = TreeNode(d) if d is not None else None
                _queue.append(node.left)
                index += 1
                if index >= length:
                    return root
                d = data[index]
                node.right = TreeNode(d) if d is not None else None
                _queue.append(node.right)
                index += 1
            queue = _queue

        return root
