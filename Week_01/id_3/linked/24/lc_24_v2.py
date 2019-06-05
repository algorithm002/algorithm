def swap(head):
    if not head or not head.next:
        return head

    result = head.next

    while head and head.next:
        nxt = head.next
        tmp = nxt.next
        nxt.next = head
        head.next = (tmp and tmp.next) or tmp
        head = tmp

    return result
