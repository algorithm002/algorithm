import lc_24_v1
import lc_24_v2

# f = lc_24_v1.swap
f = lc_24_v2.swap


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def build(l):
    root = None
    prev = None
    for x in l:
        node = ListNode(x)
        if prev:
            prev.next = node
        if not root:
            root = node
        prev = node

    return root


def export(root):
    r = [root.val]
    while root.next:
        root = root.next
        r.append(root.val)
    print(r)
    return r


def check(l, r):
    _r = export(f(build(l)))
    print(_r, _r == r)


check([1, 2, 3, 4], [2, 1, 4, 3])
check([1, 2, 3], [2, 1, 3])
