import lc_21_v1

f = lc_21_v1.merge


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


def check(l1, l2, r):
    print(export(f(build(l1), build(l2))) == r)


check([1, 2, 4], [1, 3, 4], [1, 1, 2, 3, 4, 4])
