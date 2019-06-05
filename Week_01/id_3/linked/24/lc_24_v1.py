def swap(head):
    if not head:
        return None
    nxt = head.next
    if not nxt:
        return head
    tmp = nxt.next
    nxt.next = head
    head.next = swap(tmp)
    return nxt
