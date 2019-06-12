class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Codec:

    def serialize(self, root):
        if not root:
            return []
        print(self.length(root, 1))
        data = [None] * (self.length(root, 1) + 1)
        self._s(root, 1, data)
        return data[1:]

    def _s(self, node, i, data):
        if not node:
            return
        data[i] = node.val
        self._s(node.left, 2*i, data)
        self._s(node.right, 2*i+1, data)

    def length(self, node, i):
        if not node:
            return 0
        return max(i, self.length(node.left, 2*i), self.length(node.right, 2*i+1))

    def deserialize(self, data):
        if data is None:
            return None
        data.insert(0, None)
        return self._de(1, data)

    def _de(self, i, data):
        if i >= len(data):
            return None
        v = data[i]
        if v is None:
            return None
        node = TreeNode(v)
        i = 2 * i
        node.left = self._de(i, data)
        node.right = self._de(i + 1, data)
        return node
