# 尝试使用广度优先 比较层内是否对称
def is_symmetric(root):
    queue = [root.left, root.right]
    while len(queue) > 0:
        r = is_mirror(queue)
        if not r:
            return False
        for i in range(len(queue)):
            n = queue.pop()
            if not n:
                continue
            queue.insert(0, n.left)
            queue.insert(0, n.right)

    return True


def is_mirror(queue):
    length = len(queue)
    if length == 1:
        return True
    if length % 2 == 1:
        return False

    for i in range(int(length/2)):
        n1 = queue[i]
        n2 = queue[length - i - 1]
        if not n1 and not n2:
            continue
        if bool(n1) != bool(n2):
            return False
        if n1.val != n2.val:
            return False

    return True
