def swap(head):
    if not head or not head.next:
        return head
    nxt = head.next
    head.next = swap(nxt.next)
    nxt.next = head
    return nxt
