class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def swap(head):
    if not head or not head.next:
        return head

    root = prev = ListNode(0)
    while head and head.next:
        nxt = head.next
        prev.next = nxt
        nxt.next, prev, head = head, head, nxt.next

    prev.next = head
    return root.next
