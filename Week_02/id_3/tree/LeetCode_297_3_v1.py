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
            node = queue.pop()
            if not node:
                none_count += 1
                data.append(None)
                continue

            none_count = 0
            data.append(node.val)
            queue.insert(0, node.left)
            queue.insert(0, node.right)
        return data[:-none_count]

    def deserialize(self, data):
        if not data:
            return None

        root = TreeNode(data[0])
        queue = [root]
        length = len(data)
        for i in range(1, length, 2):
            node = queue.pop()
            if data[i] is not None:
                node.left = TreeNode(data[i])
                queue.insert(0, node.left)

            if i + 1 == length:
                break
            if data[i + 1] is not None:
                node.right = TreeNode(data[i + 1])
                queue.insert(0, node.right)

        return root
