class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def merge(l1, l2):
    cur = root = ListNode(0)
    while l1 and l2:
        if l1.val > l2.val:
            l1, l2 = l2, l1
        cur.next = l1
        cur = l1
        l1 = l1.next
    cur.next = l1 or l2
    return root.next
